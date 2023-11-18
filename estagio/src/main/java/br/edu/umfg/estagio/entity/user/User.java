package br.edu.umfg.estagio.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_user")
public class User {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String email;
    private String password;

    public User(UserRequestDTO data){
        this.email = data.email();
        this.password = encoder.encode(data.password());
    }

    public void updateFromDTO(UserRequestDTO data){
        if (data.email() != null){
            this.email = data.email();
        }
        if (data.password() != null){
            this.password = encoder.encode(data.password());
        }
    }
}
