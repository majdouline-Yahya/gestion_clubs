package metierService;

import java.util.Collection;
import java.util.List;

import entities.Club;
import entities.Evenement;
import entities.membreAdherant;

public interface IClubService {
    
	//consulter les clubs
	public List<Club> consulterTousClubs();
	//consulter un club
	public Club consulterClub(Long idClub);
	//consulter un club par nom
	public List<Club> consulterClubIntitule(String intitule);
	//ajouter un club
	public Club ajouterClub(Club c);
	//supprimerclub
	public void supprimerClub(Long idClub);
	//modifierclub
	public Club modifierClub(Club c);
	//tous membre adherants
	public Collection<membreAdherant> TousMembres(Long id);
	//tous les evenements d'un club
	public Collection<Evenement> evenementsClub(Long idClub);
	
}
