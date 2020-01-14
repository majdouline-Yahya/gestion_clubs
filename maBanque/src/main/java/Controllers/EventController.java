package Controllers;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Club;
import entities.Evenement;
import metierService.IEventService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/events")
public class EventController {
    
	 @Autowired
	 private IEventService eventService;
	 
	 @RequestMapping(value="/all",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Evenement>> evenements(){
		 Collection<Evenement> evenements=eventService.findAll();
		 return new ResponseEntity<Collection<Evenement>>(evenements,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/all/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Evenement> getEvent(@PathVariable("id") Long id) {
		 Evenement evenement=eventService.findOne(id);
		 if(evenement==null) {
			 return new ResponseEntity<Evenement>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Evenement>(evenement,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/description/{description}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Evenement>> getEventByDescription(@PathVariable("description") String description) {
		 Collection<Evenement> evenements=eventService.findByDescription(description);
		
		 return new ResponseEntity<Collection<Evenement>>(evenements,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/theme/{theme}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Evenement>> getEventByTheme(@PathVariable("theme") String theme) {
		 Collection<Evenement> evenements=eventService.findByTheme(theme);
		
		 return new ResponseEntity<Collection<Evenement>>(evenements,HttpStatus.OK);
	 }
	 
	 
	 @RequestMapping(value="/create",method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Evenement> createEvent(@RequestBody Evenement evenement){
		 
		 Evenement evenementCreated= eventService.create(evenement);
		 return new ResponseEntity<Evenement>(evenementCreated,HttpStatus.CREATED);
	 }
	 
	 
	 @RequestMapping(value="/update/{id}",method=RequestMethod.PUT,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Evenement> updateEvent(@PathVariable Long id,@RequestBody Evenement evenement) {
		 
		 Evenement evenementUpdated=null;
		 if(evenement!=null && id==evenement.getIdEvent()) {
			evenementUpdated=eventService.update(evenement);
		 }
		 if(evenement==null) {
			return new ResponseEntity<Evenement>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		 return new ResponseEntity<Evenement>(evenementUpdated,HttpStatus.OK);
	}
	 
	 
	 @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	 public ResponseEntity<Evenement> deleteEvent(@PathVariable Long id){
		    eventService.delete(id);
		    return new ResponseEntity<Evenement>(HttpStatus.NO_CONTENT);
	 }
	 
	 

		@RequestMapping(value="/clubsOfEvents/{idEvent}",method=RequestMethod.GET,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		 public ResponseEntity<Collection<Club>> findClubsOfEvent(@PathVariable("idEvent") Long idEvent) {
			 Collection<Club> clubs=eventService.findClubsOfEvent(idEvent);
			
			 return new ResponseEntity<Collection<Club>>(clubs,HttpStatus.OK);
		 }
	 
	 
		
	 
	 
	 
	 
	 
	 
	 
	 
	
 
	
}
