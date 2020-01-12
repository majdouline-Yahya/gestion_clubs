package metierService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CompteRepository;
import entities.Compte;

@Service
public class CompteImpl implements ICompteService{
	@Autowired
	public CompteRepository compteRepository;
	
	
	@Override
	public Collection<Compte> findAll() {
		Collection<Compte> comptes= compteRepository.findAll();
		return comptes;
	}
 
	@Override
	public Collection<Compte> findByLogin(String login) {
		Collection<Compte> comptes= compteRepository.findByLogin(login);
		return comptes;
	}

	@Override
	public Compte findOne(Long id) {
		Compte compte=null;
		try {
			compte=compteRepository.getOne(id);
			
		} catch (Exception e) {
				return null;
		}
		
		return compte;
	
	}

	
	@Override
	public Compte create(Compte compte) {
		Compte compte2 = compteRepository.save(compte) ;
		return compte2;
	}

	@Override
	public Compte update(Compte compte) {

		Compte compteup=compteRepository.getOne(compte.getIdCompte());
		
		if(compteup==null)
		{
			return null;
		}
		Compte compteUpdated=compteRepository.save(compte);
		return compteUpdated;
		
	}

	@Override
	public void delete(Long id) {
		Compte compte = compteRepository.getOne(id) ;
		compteRepository.delete(compte);
		
	}
}
