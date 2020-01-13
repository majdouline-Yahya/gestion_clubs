package Controllers;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import entities.Compte;
import metierService.ICompteService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/comptes")
public class CompteController {

	 @Autowired
	 private ICompteService compteService;
	 
	 @RequestMapping(value="/all",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Compte>> comptes(){
		 Collection<Compte> comptes= compteService.findAll();
		 return new ResponseEntity<Collection<Compte>>(comptes,HttpStatus.OK);
	 }
	
	 
	 
	 
	 
	 @RequestMapping(value="/all/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Compte> getCompte(@PathVariable("id") Long id) {
		 Compte compte=compteService.findOne(id);
		 if(compte==null) {
			 return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Compte>(compte,HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value="/login/{login}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Compte>> getCompteByLogin(@PathVariable("login") String login) {
		 Collection<Compte> comptes=compteService.findByLogin(login);
		
		 return new ResponseEntity<Collection<Compte>>(comptes,HttpStatus.OK);
	 }
	 
	 
	 
	 @RequestMapping(value="/create",method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Compte> createCompte(@RequestBody Compte compte){
		 
		 Compte compteCreated= compteService.create(compte);
		 return new ResponseEntity<Compte>(compteCreated,HttpStatus.CREATED);
	 }
	 
	 
	 
	 @RequestMapping(value="/update/{id}",method=RequestMethod.PUT,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Compte> updateCompte(@PathVariable("id") Long id,@RequestBody Compte compte) {
		 
		 Compte compteUpdated=null;
		 if(compte!=null && id==compte.getIdCompte()) {
			compteUpdated=compteService.update(compte);
		 }
		 if(compte==null) {
			return new ResponseEntity<Compte>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		 return new ResponseEntity<Compte>(compteUpdated,HttpStatus.OK);
	}
	 
	 @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	 public ResponseEntity<Compte> deleteCompte(@PathVariable("id") Long id){
		    compteService.delete(id);
		    return new ResponseEntity<Compte>(HttpStatus.NO_CONTENT);
	 }
	 	 	 
	 @RequestMapping(value="/verifyLogin",method=RequestMethod.POST,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public ResponseEntity<Compte> VerifyLogin(@RequestBody ObjectNode objectNode){
		 String login=objectNode.get("login").asText();
		 String password=objectNode.get("password").asText();
		 Compte compte= compteService.verifyLogin(login, password);
		 if(compte==null) {
				return new ResponseEntity<Compte>(HttpStatus.NOT_FOUND);
			}
		 return new ResponseEntity<Compte>(compte,HttpStatus.OK);
	 }
	 
	 
}
