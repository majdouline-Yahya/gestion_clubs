package metierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClubRepesitory;
import entities.Club;

@Service
@Transactional
public class ClubImpl implements IClubService{
	@Autowired
	private ClubRepesitory clubReository;
	
	
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
		return clubReository.save(c);
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

}
