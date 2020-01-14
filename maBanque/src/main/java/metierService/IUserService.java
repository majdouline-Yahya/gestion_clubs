package metierService;

import java.util.Collection;



import entities.Evenement;
import entities.Utilisateur;

public interface IUserService {
	Collection<Utilisateur> findAll();
	Utilisateur findOne(Long idUser);
	Utilisateur findByMail(String email);
	Utilisateur create(Utilisateur utilisateur);
	Utilisateur update(Utilisateur utilisateur);
	 String findRoleOfUser(Long idUser);
	void delete(Long idUser);
}
