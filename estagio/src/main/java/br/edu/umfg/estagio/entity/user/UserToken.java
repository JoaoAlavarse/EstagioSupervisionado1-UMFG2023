package br.edu.umfg.estagio.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_token")
public class UserToken {
    @Id
    @Column(name = "token")
    private String token;
    @Column(name = "user_email")
    private String userEmail;

    public String getToken() {
        return token;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public UserToken(String token, String userEmail) {
        this.token = token;
        this.userEmail = userEmail;
    }

    protected UserToken() {
    }
}
