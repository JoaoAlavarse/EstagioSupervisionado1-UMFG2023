package br.edu.umfg.estagio.config;

import br.edu.umfg.estagio.repository.user.UserTokenRepository;
import br.edu.umfg.estagio.service.authentication.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter extends HttpFilter {
    @Autowired
    private AuthenticationService authenticationService;
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!request.getRequestURI().equals("/login")){
            String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader == null){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
            String token = authorizationHeader.substring(7);
            if (!authenticationService.validate(token)){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }
        System.out.println("TESTEAGORA");
        super.doFilter(request, response, chain);
    }
}
