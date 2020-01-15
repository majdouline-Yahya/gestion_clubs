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

import dao.CandidatureRepesitory;
import dao.ClientRepository;
import dao.ClubRepository;
import dao.CompteRepository;
import dao.EvenementRepository;
import entities.Admin;
import entities.Candidature;
import entities.Club;
import entities.Compte;
import entities.Evenement;
import entities.TeamLeader;
import entities.Utilisateur;
import entities.membreAdherant;
import javassist.expr.NewArray;



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
	private ClubRepository clubRepository;
	@Autowired 
	private CandidatureRepesitory candidatureRepesitory;
	public static void main(String[] args) {
		   
		   SpringApplication.run(Application.class, args);
		  
	}
	
	@Override
	public void run(String... args) throws Exception {
		//tester l'ajout a la base de donnees!!!
		Set<membreAdherant> mem=new HashSet<>();
		Set<Evenement> eve=new HashSet<>();
		TeamLeader tl=clientRepository.save(new TeamLeader("LAAROUSSI", "houda96@gmail.com", 23));
		Admin admin= clientRepository.save(new Admin("Mehdi","mehdi@gmail.com",22));
		
		membreAdherant m=clientRepository.save(new membreAdherant("YAHYA", "yahya96@gmail.com", 23));
		mem.add(m);
		membreAdherant m1=clientRepository.save(new membreAdherant("Ahmad", "med159@gmail.com", 23));
		mem.add(m1);
		membreAdherant m2=clientRepository.save(new membreAdherant("rachide", "rachide45@gmail.com", 23));
		mem.add(m2);
		membreAdherant m3=clientRepository.save(new membreAdherant("yasmine", "yasmin12@gmail.com", 23));
		mem.add(m3);
		Utilisateur utilisateur=new Utilisateur("Yahya", "test@test.com", 26);
		Utilisateur utilisateur2=new Utilisateur("lina", "test@test.com", 30);
		Set<membreAdherant> mem1=new HashSet<>();
		mem1.add(m);
		mem1.add(m2);
		
		
		
		Evenement e1=evenementRepository.save(new Evenement("titre1","intellectuelle", "jounée de vie", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve.add(e1);
		Evenement e2=evenementRepository.save(new Evenement("titre1","intelligence", "recrutement", "fsjes", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve.add(e2);
		Evenement e3=evenementRepository.save(new Evenement("titre1","biologie", "recrutement", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve.add(e3);
		Evenement e4=evenementRepository.save(new Evenement("titre1","informatique", "chatbot", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve.add(e4);
		
		
		
		Club club1= new Club("C.O.D.E","ce club concerne tout ce qui est codage et programmation", new Date(), tl,mem, eve);
		Club club= new Club("girls Code","ce club est juste pour les filles programmeuses ", new Date(), tl,mem1, eve);
		Club club3= new Club("Code it","ce club est la combinaison de tout ce qui est informatique et mathematique", new Date(), tl,null, null);
		
		clubRepository.save(club1);
		clubRepository.save(club);
		clubRepository.save(club3);
		
		clientRepository.save(utilisateur);
		clientRepository.save(utilisateur2);
		clubRepository.save(club);
		
		candidatureRepesitory.save(new Candidature(utilisateur, club, "motivation", "skills", new Date()));
		candidatureRepesitory.save(new Candidature(utilisateur2, club, "motivation3", "skills3", new Date()));
		
		
		Compte compte= new Compte("majdouline yahya", "majdo", m);
		Compte compte3= new Compte("mehdi", "mehdi", admin);
		Compte compte2= new Compte("rachide", "1344", m2);
		Compte compte5= new Compte("houda", "houda", tl);
		Compte test= new Compte("test", "test", utilisateur);
		compteRepository.save(compte);
		compteRepository.save(compte2);
		compteRepository.save(compte3);
		compteRepository.save(compte5);
		compteRepository.save(test);
		

}}
