package metierService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Controllers.clubController;
import dao.ClientRepository;
import dao.ClubRepository;
import entities.Club;
import entities.Compte;
import entities.Evenement;
import entities.TeamLeader;
import entities.Utilisateur;
import entities.membreAdherant;

@Service
@Transactional
public class ClubImpl implements IClubService{
	@Autowired
	private ClubRepository clubReository;
	
	@Autowired 
	private ClientRepository ClientRepository;
	
	@Autowired
	private IUserService userService;
	
	@Autowired 
	private ICompteService compteService;
	
	@Override
	public Club consulterClub(Long idClub) {
		Optional<Club> club=clubReository.findById(idClub);
		if(club.isPresent()) 
			{
			return club.get();
			}
		else {
		throw new RuntimeException("Club innexistant");
		}
	}

	@Override
	public Club ajouterClub(Club c) {
		TeamLeader teamLeader= c.getTeamLeader();
		ClientRepository.save(teamLeader);
		c.setDateCreation(new Date());
		Club club= clubReository.save(c);
		String mail= teamLeader.getEmail();
		String password= "pass";
		Compte compte= new Compte(mail, password, teamLeader);
		compteService.create(compte);
		return club;
		//Utilisateur utilisateur=ClientRepository.findByMail(mail);
		
		/*if(utilisateur==null) return null;
		else {
			

			ClientRepository.UpdateRoleOfUser("TeamLeader", utilisateur.getIdUser());
			//Club club= clubReository.save(c);
		
		  //ClientRepository.UpdateRoleOfUser( "TeamLeader",utilisateur.getIdUser());
		  //  ClientRepository.deleteFromMembresClub(utilisateur.getIdUser());
			
			
			return null;
		}*/
		
	}

	@Override
	public void supprimerClub(Long idClub) {
		Club club=consulterClub(idClub);
		if(club!=null)
		{
			clubReository.delete(club);
		}
		else {
			throw new RuntimeException("Club innexistant");
			}
		
	}

	@Override
	public Club modifierClub(Club c) {
		Club club=consulterClub(c.getIdClub());
		if(club!=null)
		{
			club.setIdClub(c.getIdClub());
			club.setDateCreation(c.getDateCreation());
			club.setIntitule(c.getIntitule());
			club.setTeamLeader(c.getTeamLeader());
			club=clubReository.save(club);
			return club;
		}
		else {
			throw new RuntimeException("Club innexistant");
			}
		
	}

	@Override
	public List<Club> consulterTousClubs() {
		List<Club> clubs=clubReository.findAll();
		if(clubs.size()>0)
		{
			return clubs;
		}else
		{
			return new ArrayList<Club>();
		}
	}

	@Override
	public List<Club> consulterClubIntitule(String intitule) {
		List<Club> clubs=clubReository.consultByIntitule(intitule);
		if(clubs.size()>0)
		{
			return clubs;
		}else
		{
			return new ArrayList<Club>();
		}
	}

	@Override
	public Collection<membreAdherant> TousMembres(Long id) {
		Club club=this.consulterClub(id);
		Collection<membreAdherant> membreAdherants=club.getMembreAdherants();
		return membreAdherants;
		
	}

	@Override
	public Collection<Evenement> evenementsClub(Long idClub) {
		Club club=this.consulterClub(idClub);
		Collection<Evenement> evenements=club.getEvenements();
		return evenements;
	}

}
