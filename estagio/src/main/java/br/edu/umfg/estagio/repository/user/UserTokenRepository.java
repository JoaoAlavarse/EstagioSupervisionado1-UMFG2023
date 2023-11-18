package br.edu.umfg.estagio.repository.user;

import br.edu.umfg.estagio.entity.user.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, String> {
    void deleteByUserEmail(String userEmail);
}
