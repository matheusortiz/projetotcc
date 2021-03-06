package com.pucminas.tcc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pucminas.tcc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	/* instanciação e povoamento do BD de testes */
	
	@Bean
	public boolean instantiateDatabase() {
		dbService.instantiateTestDataBase();
		return true;
	}
}
