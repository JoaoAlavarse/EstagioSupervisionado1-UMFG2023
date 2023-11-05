package br.edu.umfg.estagio.entity.user;

public record UserResponseDTO(Long id_user, String email, String password) {
    public UserResponseDTO(User user){
        this(user.getId_user(), user.getEmail(), user.getPassword());
    }
}
