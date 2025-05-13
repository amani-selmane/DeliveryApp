package com.example;

// Import des outils Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Indique que c'est une application Spring Boot
@SpringBootApplication
public class OnlineFoodOrderApplication {

	// Point d'entrée de l'application
	public static void main(String[] args) {
		// Démarre l'application Spring Boot
		SpringApplication.run(OnlineFoodOrderApplication.class, args);
	}

}
