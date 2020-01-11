package Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Club;
import metierService.ClubImpl;
import metierService.IClubService;

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
	
	@RequestMapping(value="/all/{id}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Club> consulterClub(@PathVariable("id") Long id)
	{
			Club club = cl.consulterClub(id);
			return new ResponseEntity<Club>(club, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Club> ajouterClub(Club c)
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
}