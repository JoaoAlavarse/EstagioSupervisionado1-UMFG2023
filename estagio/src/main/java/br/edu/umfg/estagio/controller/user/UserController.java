package br.edu.umfg.estagio.controller.user;

import br.edu.umfg.estagio.entity.user.UserRequestDTO;
import br.edu.umfg.estagio.entity.user.UserResponseDTO;
import br.edu.umfg.estagio.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        List<UserResponseDTO> userList = service.getAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody UserRequestDTO data){
        if (service.login(data)){
            return ResponseEntity.ok("Autenticação bem-sucedida");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody UserRequestDTO data){
        service.saveUser(data);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/{id_user}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id_user, @RequestBody UserRequestDTO data){
        service.updateUser(id_user, data);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(value = "/{id_user}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id_user){
        service.deleteUser(id_user);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/{id_user}")
    public ResponseEntity<Optional<UserResponseDTO>> getById(@PathVariable Long id_user){
        Optional<UserResponseDTO> optionalUser = service.getById(id_user);
        return ResponseEntity.ok(optionalUser);
    }
}
