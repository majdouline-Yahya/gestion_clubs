package Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Candidature;
import entities.Evenement;
import metierService.ICandidatureService;

@RestController
@RequestMapping(value="/candidatures")
public class CandidaturesController {
	
	 @Autowired
	 private ICandidatureService candidatureService;
	 
	 @RequestMapping(value="/all",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Candidature>> candidatures(){
		 Collection<Candidature> candidatures=candidatureService.findAll();
		 return new ResponseEntity<Collection<Candidature>>(candidatures,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/all/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Candidature> getCandidature(@PathVariable("id") Long id) {
		 Candidature candidature=candidatureService.findOne(id);
		 if(candidature==null) {
			 return new ResponseEntity<Candidature>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Candidature>(candidature,HttpStatus.OK);
	 }

	 @RequestMapping(value="/club/{idClub}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Candidature>> getCandidaturesByClub(@PathVariable("idClub") Long idClub) {
		 Collection<Candidature> candidatures=candidatureService.findByIdClub(idClub);
		
		 return new ResponseEntity<Collection<Candidature>>(candidatures,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/user/{idUser}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Candidature>> getCandidaturesByUser(@PathVariable("idUser") Long idUser) {
		 Collection<Candidature> candidatures=candidatureService.findByIdUser(idUser);
		
		 return new ResponseEntity<Collection<Candidature>>(candidatures,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/create",method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Candidature> createCandidature(@RequestBody Candidature candidature){
		 
		 Candidature candidatureCreated= candidatureService.create(candidature);
		 return new ResponseEntity<Candidature>(candidatureCreated,HttpStatus.CREATED);
	 }
	 
	 
	 @RequestMapping(value="/update/{id}",method=RequestMethod.PUT,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Candidature> updateCandidature(@PathVariable Long id,@RequestBody Candidature candidature) {
		 
		 Candidature candidatureUpdated=null;
		 if(candidature!=null && id==candidature.getIdCandidature()) {
			candidatureUpdated=candidatureService.update(candidature);
		 }
		 if(candidature==null) {
			return new ResponseEntity<Candidature>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		 return new ResponseEntity<Candidature>(candidatureUpdated,HttpStatus.OK);
	}
	 
	 
	 @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	 public ResponseEntity<Candidature> deleteEvent(@PathVariable Long id){
		    candidatureService.delete(id);
		    return new ResponseEntity<Candidature>(HttpStatus.NO_CONTENT);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
