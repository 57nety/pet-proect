package com.pet;

import com.pet.entities.User;
import com.pet.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.pet.entities.Favorites;

@SpringBootApplication
public class PetApplication {

	private static final Logger log = LoggerFactory.getLogger(PetApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserService userService) {
		return (args) -> {
			User user = new User();
			user.setLogin("login");

			Favorites favorites = new Favorites();
			favorites.setBookId(130120);
			favorites.setBookTitle("А.Т. Гречанинов. Неизвестные произведения позднего творчества композитора. Вып. 1: литургия № 4 «Новый обиход», ор. 177");
			favorites.setBookLink("http://www.iprbookshop.ru/130120.html");

			user.addFavorites(favorites);

			userService.createUser(user);
		};
	}

}
