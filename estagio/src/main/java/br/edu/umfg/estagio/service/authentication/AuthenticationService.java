package br.edu.umfg.estagio.service.authentication;

import br.edu.umfg.estagio.entity.user.User;
import br.edu.umfg.estagio.entity.user.UserRequestDTO;
import br.edu.umfg.estagio.entity.user.UserToken;
import br.edu.umfg.estagio.repository.user.UserRepository;
import br.edu.umfg.estagio.repository.user.UserTokenRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.naming.AuthenticationException;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserTokenRepository tokenRepository;
    private static final SecretKey key = sign();

    @Transactional
    public String login(UserRequestDTO data) throws AuthenticationException {
        User user = userRepository.findByEmail(data.email());
        if(user == null || !passwordEncoder.matches(data.password(), user.getPassword())){
            throw new AuthenticationException("Authentication Failure");
        }

        String jwt = Jwts.builder()
                .setIssuer("EstagioIssuer")
                .setSubject(user.getEmail())
                .claim("scope", "user")
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(8, ChronoUnit.HOURS)))
                .signWith(key).compact();
        tokenRepository.deleteByUserEmail(user.getEmail());
        tokenRepository.save(new UserToken(jwt, user.getEmail()));
        return jwt;
    }

    public boolean validate(String token){
        if (tokenRepository.findById(token).isPresent()){
            try {
                Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
                return true;
            } catch (JwtException e){
                System.out.println(e);
                return false;
            }
        }
        return false;
    }

    private static SecretKey sign(){
        byte[] secretKeyBytes = (byte[]) Decoders.BASE64.decode("ajibfoiabsfpiuasbpdfiuabspidfubapsidufbasdfasdfsdfajibfoiabsfpiuasbpdfiuabspidfubapsidufbasdfasdfsdf");
        return new SecretKeySpec(secretKeyBytes, SignatureAlgorithm.HS512.getJcaName());
    }

}


