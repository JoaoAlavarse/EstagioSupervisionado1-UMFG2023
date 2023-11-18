package br.edu.umfg.estagio.controller.authentication;

import br.edu.umfg.estagio.entity.user.UserRequestDTO;
import br.edu.umfg.estagio.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationService service;
    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserRequestDTO data){
        try{
            String jwtToken = service.login(data);
            return ResponseEntity.ok(jwtToken);
        } catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
