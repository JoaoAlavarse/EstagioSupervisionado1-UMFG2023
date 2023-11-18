package br.edu.umfg.estagio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EstagioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstagioApplication.class, args);
		System.out.println("FUNCIONANDO");
	}

	@Bean
	public PasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
}
