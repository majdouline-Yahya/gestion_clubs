package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import Controllers.EventController;
import dao.ClientRepository;
import dao.CompteRepository;
import dao.EvenementRepository;
import metierService.IClubService;



@SpringBootApplication 

@EntityScan(basePackages = {"entities"}) @EnableJpaRepositories(basePackages ="dao")
@ComponentScan(basePackages = "Controllers")
@ComponentScan(basePackages = "entities")
@ComponentScan(basePackages = "metierService")
public class Application implements CommandLineRunner{
    
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private EvenementRepository evenementRepository;
	
//	@Autowired 
//	private IClubService clubService;
	
	public static void main(String[] args) {
		   
		   SpringApplication.run(Application.class, args);
		  
	}
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
