package metierService;

import java.util.List;

import entities.Club;

public interface IClubService {
    
	//consulter les clubs
	public List<Club> consulterTousClubs();
	//consulter un club
	public Club consulterClub(Long idClub);
	//ajouter un club
	public Club ajouterClub(Club c);
	//supprimerclub
	public void supprimerClub(Long idClub);
	//modifierclub
	public Club modifierClub(Club c);
}
