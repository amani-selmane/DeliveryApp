package com.example.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Classe de configuration Spring
@Configuration
public class AppConfig {

	// Crée et rend disponible un objet ModelMapper dans tout le projet
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
