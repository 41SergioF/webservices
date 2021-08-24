package com.carlossergio.webservices.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carlossergio.webservices.entities.User;
import com.carlossergio.webservices.repositories.UserRepository;

/*Primeira mente essa classe irá servir para popular o DB
 * 
 * Como faz isso ser executado quando o programa for rodado?
 * Para isso fazemos a classe implementar a interface para isso */

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	/*
	 * Vamos agora fazer uma injeção de dependência. O framework SpringBoot já tem
	 * uma uma injeção padrão, precisamos usar a anotação @Autowired para isso
	 */
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}