package br.edu.umfg.estagio.service.user;

import br.edu.umfg.estagio.entity.user.User;
import br.edu.umfg.estagio.entity.user.UserRequestDTO;
import br.edu.umfg.estagio.entity.user.UserResponseDTO;
import br.edu.umfg.estagio.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void updateUser(Long id_user, UserRequestDTO data){
        Optional<User> optionalUser = repository.findById(id_user);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            user.updateFromDTO(data);
            repository.save(user);
        }
    }

    public List<UserResponseDTO> getAll(){
        List<UserResponseDTO> userList = repository.findAll().stream().map(UserResponseDTO::new).toList();
        return userList;
    }

    public void saveUser(@RequestBody UserRequestDTO data){
        User user = new User(data);

        repository.save(user);
    }

    public void deleteUser(@PathVariable Long id_user){
        Optional<User> optionalUser = repository.findById(id_user);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            repository.delete(user);
        }
    }

    public Optional<UserResponseDTO> getById(Long id_user){
        Optional<UserResponseDTO> user = repository.findById(id_user).map(UserResponseDTO::new);
        return user;
    }


}
