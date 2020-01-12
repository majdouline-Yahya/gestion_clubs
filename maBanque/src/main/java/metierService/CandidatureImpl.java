package metierService;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CandidatureRepesitory;
import dao.EvenementRepository;
import entities.Candidature;
import entities.Club;
import entities.Evenement;
import entities.Utilisateur;

@Service
public class CandidatureImpl implements ICandidatureService {

	@Autowired
	public CandidatureRepesitory candidatureRepesitory;
	
	@Override
	public Collection<Candidature> findAll() {
		Collection<Candidature> evenements= candidatureRepesitory.findAll();
		return evenements;
	}

	@Override
	public Collection<Candidature> findByIdClub(Long idClub) {
		Collection<Candidature> candidatures= candidatureRepesitory.candidaturesClub(idClub);
		return candidatures;
	}

	@Override
	public Collection<Candidature> findByIdUser(Long idUser) {
		Collection<Candidature> candidatures= candidatureRepesitory.candidaturesUser(idUser);
		return candidatures;
	}

	@Override
	public Candidature findOne(Long idCandidature) {
		Candidature candidature=null;
		try {
			candidature=candidatureRepesitory.getOne(idCandidature);
			
		} catch (Exception e) {
				return null;
		}
		
		return candidature;
	}

	@Override
	public Candidature create(Candidature candidature) {
		Candidature candidatureCreated=candidatureRepesitory.save(candidature);
		return candidatureCreated;
	}

	@Override
	public Candidature update(Candidature candidature) {
		Candidature candidatureUp=candidatureRepesitory.getOne(candidature.getIdCandidature());
		if(candidatureUp==null)
		{
			return null;
		}
		Candidature candidatureUpdated=candidatureRepesitory.save(candidature);
		return candidatureUpdated;
	}

	@Override
	public void delete(Long id) {
		Candidature candidature=candidatureRepesitory.getOne(id);
		candidatureRepesitory.delete(candidature);		
	}

	@Override
	public void accept(Candidature candidature) {
	    
	    	Utilisateur utilisateur=candidature.getUtilisateur();
		    Club club= candidature.getClub();
		    candidatureRepesitory.BecomeMember(utilisateur.getIdUser(), club.getIdClub());
		    candidatureRepesitory.delete(candidature);
			
	    
	}

}
