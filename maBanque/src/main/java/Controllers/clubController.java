package Controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Club;
import entities.Evenement;
import entities.membreAdherant;
import metierService.ClubImpl;
import metierService.IClubService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/clubs")
public class clubController {

	@Autowired
	IClubService cl;
	
	
	@RequestMapping(value="/all",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Club>> consulterTousClubs()
	{
		List<Club> list=cl.consulterTousClubs();
		return new ResponseEntity<List<Club>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/search/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Club> consulterClub(@PathVariable("id") Long id)
	{
			Club club = cl.consulterClub(id);
			return new ResponseEntity<Club>(club, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/name/{intitule}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Club>> consulterClubsIntitule(@PathVariable("intitule") String intitule)
	{
		List<Club> list=cl.consulterClubIntitule(intitule);
		return new ResponseEntity<List<Club>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/allMembers/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<membreAdherant>> TousMemberes(@PathVariable("id") Long id)
	{
		Collection<membreAdherant> list=cl.TousMembres(id);
		return new ResponseEntity<Collection<membreAdherant>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Club> ajouterClub(@RequestBody Club c)
	{
		Club club = cl.ajouterClub(c);
		return new ResponseEntity<Club>(club, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Club> modifierClub(@PathVariable Long id,@RequestBody Club c)
	{
		Club club = cl.modifierClub(c);
		return new ResponseEntity<Club>(club, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus supprimerClub(@PathVariable("id") Long id)
	{
		cl.supprimerClub(id);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/eventsClub/{idClub}",method=RequestMethod.GET,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Collection<Evenement>> findEventsOfClub(@PathVariable("idClub") Long idClub) {
		 Collection<Evenement> evenements=cl.evenementsClub(idClub);
		
		 return new ResponseEntity<Collection<Evenement>>(evenements,HttpStatus.OK);
	 }
}
