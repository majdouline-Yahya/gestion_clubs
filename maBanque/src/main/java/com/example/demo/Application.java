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
		Set<Evenement> eve233=new HashSet<>();
		Set<Evenement> eve23=new HashSet<>();
		Set<Evenement> eve235=new HashSet<>();
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
		Utilisateur utilisateur=new Utilisateur("yahya lina", "yahya88@test.com", 26);
		Utilisateur utilisateur2=new Utilisateur("lina", "test@test.com", 30);
		Set<membreAdherant> mem1=new HashSet<>();
		mem1.add(m);
		mem1.add(m2);
		
		
		
		Evenement e1=evenementRepository.save(new Evenement("Conférence Intelligence Artificielle","IT", "Le Gouvernement de Chine ", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve.add(e1);
		Evenement e2=evenementRepository.save(new Evenement("Recrutement","Recrutement de nouveaux membres", "recrutement", "fsjes", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve233.add(e2);
		Evenement e3=evenementRepository.save(new Evenement("Recrutement","Rejoignez-nous!", "recrutement", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve23.add(e3);
		Evenement e5=evenementRepository.save(new Evenement("Recrutement","On Recrute!", "recrutement", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve235.add(e5);
		Evenement e4=evenementRepository.save(new Evenement("Conférence en Informatique ","informatique", "chatbot", "fst settat", new Date(2020, 02, 15), new Date(2020, 02, 15), null));
		eve.add(e4);
		
		
		
		Club club1= new Club("C.O.D.E","ce club concerne tout ce qui est codage et programmation", new Date(), tl,mem, eve23);
		Club club4= new Club("UMUS","Un Mois Un Savoir : Chaque mois vous améliorez vos compétences", new Date(), tl,mem, eve235);
		Club club= new Club("girls Code","ce club est juste pour les filles programmeuses pour encourager les filles à coder ", new Date(), tl,mem1, eve233);
		Club club3= new Club("Code it","ce club est la combinaison de tout ce qui est informatique et mathematique", new Date(), tl,null, eve);
		
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
		Compte test= new Compte("yahya lina", "test", utilisateur);
		compteRepository.save(compte);
		compteRepository.save(compte2);
		compteRepository.save(compte3);
		compteRepository.save(compte5);
		compteRepository.save(test);
		

}}
