package metierService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientRepository;
import entities.Evenement;
import entities.Utilisateur;

@Service
public class UserImpl implements IUserService {

	@Autowired
	public ClientRepository clientRepository;
	@Override
	public Collection<Utilisateur> findAll() {
		Collection<Utilisateur> utilisateurs= clientRepository.findAll();
		return utilisateurs;
	}

	@Override
	public Utilisateur findOne(Long idUser) {
		Utilisateur utilisateur=null;
		try {
			utilisateur=clientRepository.getOne(idUser);
			
		} catch (Exception e) {
				return null;
		}
		
		return utilisateur;
		 
	
	}

	@Override
	public Utilisateur create(Utilisateur utilisateur) {
		Utilisateur utilisateurCreated=clientRepository.save(utilisateur);
		return utilisateurCreated;
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		Utilisateur utilisateurUp=clientRepository.getOne(utilisateur.getIdUser());
		if(utilisateurUp==null)
		{
			return null;
		}
		Utilisateur utilisateurUpdated=clientRepository.save(utilisateur);
		return utilisateurUpdated;
	}

	@Override
	public void delete(Long idUser) {
		Utilisateur utilisateur=clientRepository.getOne(idUser);
		clientRepository.delete(utilisateur);
		
	}

	@Override
	public Utilisateur findByMail(String email) {
		Utilisateur utilisateur = clientRepository.findByMail(email);
		return utilisateur;
	}

}
