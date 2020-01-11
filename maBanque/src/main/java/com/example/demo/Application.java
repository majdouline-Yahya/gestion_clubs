package com.example.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dao.ClientRepository;
import dao.ClubRepesitory;
import dao.CompteRepository;
import dao.EvenementRepository;
import entities.Club;
import entities.Evenement;
import entities.TeamLeader;
import entities.membreAdherant;



@SpringBootApplication 
@EntityScan(basePackages = {"entities"}) @EnableJpaRepositories(basePackages ="dao")
@ComponentScan(basePackages="Controllers")
@ComponentScan(basePackages="entities")
@ComponentScan(basePackages="metierService")
public class Application implements CommandLineRunner{
    
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired 
	private ClubRepesitory clubRepository;
	public static void main(String[] args) {
		   
		   SpringApplication.run(Application.class, args);
		  
	}
	
	@Override
	public void run(String... args) throws Exception {
		//tester l'ajout a la base de donnees!!!
		Set<membreAdherant> mem=new HashSet<>();
		Set<Evenement> eve=new HashSet<>();
		TeamLeader tl=clientRepository.save(new TeamLeader("LAAROUSSI", "houda96@gmail.com", 23));
		membreAdherant m=clientRepository.save(new membreAdherant("YAHYA", "yahya96@gmail.com", 23));
		mem.add(m);
		membreAdherant m1=clientRepository.save(new membreAdherant("Ahmad", "med159@gmail.com", 23));
		mem.add(m1);
		membreAdherant m2=clientRepository.save(new membreAdherant("rachide", "rachide45@gmail.com", 23));
		mem.add(m2);
		membreAdherant m3=clientRepository.save(new membreAdherant("yasmine", "yasmin12@gmail.com", 23));
		mem.add(m3);
		
		Evenement e1=evenementRepository.save(new Evenement("intellectuelle", "jounée de vie", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null, null));
		eve.add(e1);
		Evenement e2=evenementRepository.save(new Evenement("intelligence", "ingenieur de demain", "fsjes", new Date(2020, 02, 15), new Date(2020, 02, 15), null, null));
		eve.add(e2);
		Evenement e3=evenementRepository.save(new Evenement("biologie", "jumelle", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null, null));
		eve.add(e3);
		Evenement e4=evenementRepository.save(new Evenement("informatique", "chatbot", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null, null));
		eve.add(e4);
		Evenement e5=evenementRepository.save(new Evenement("informatique", "chatbot", "fst Tanger", new Date(2020, 02, 15), new Date(2020, 02, 15), null, null));
		eve.add(e5);
		clubRepository.save(new Club("C.O.D.E", new Date(), tl,null, null));
		
	}

}
