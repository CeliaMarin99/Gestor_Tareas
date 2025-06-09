package com.example.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GestorTareas1Application {

	public static void main(String[] args) {
		SpringApplication.run(GestorTareas1Application.class, args);
	}
	
	//Crear Usuarios por defecto
	 @Bean
	 public CommandLineRunner demo(UsuarioRepositorio repo) {
	 return (args) -> {
	      // save a few customers
	      repo.save(new Usuario("Celia", "celia", "ADMIN"));
	      repo.save(new Usuario("Ana", "ana", "USER"));
	      repo.save(new Usuario("Juan", "juan", "USER"));
	 	};

	 }
}
	 
