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
import org.springframework.web.bind.annotation.RestController;

import entities.Utilisateur;
import metierService.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/users")
public class ClientController {

	 @Autowired
	 private IUserService userService;
	 
	 
	 @RequestMapping(value="/all",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Utilisateur>> users(){
		 Collection<Utilisateur> utilisateurs=userService.findAll();
		 return new ResponseEntity<Collection<Utilisateur>>(utilisateurs,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/all/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Utilisateur> getUser(@PathVariable("id") Long id) {
		 Utilisateur utilisateur=userService.findOne(id);
		 if(utilisateur==null) {
			 return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Utilisateur>(utilisateur,HttpStatus.OK);
	 }
	 
	 @RequestMapping(value="/create",method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur){
		 
		 Utilisateur utilisateurCreated= userService.create(utilisateur);
		 return new ResponseEntity<Utilisateur>(utilisateurCreated,HttpStatus.CREATED);
	 }
	 
	 
	 @RequestMapping(value="/update/{id}",method=RequestMethod.PUT,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Utilisateur> updateUser(@PathVariable Long id,@RequestBody Utilisateur utilisateur) {
		 
		 Utilisateur utilisateurUpdated=null;
		 if(utilisateur!=null && id==utilisateur.getIdUser()) {
			utilisateurUpdated=userService.update(utilisateur);
		 }
		 if(utilisateur==null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		 return new ResponseEntity<Utilisateur>(utilisateurUpdated,HttpStatus.OK);
	}
	 
	 @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	 public ResponseEntity<Utilisateur> deleteUser(@PathVariable Long id){
		    userService.delete(id);
		    return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
	 }
	 
}
