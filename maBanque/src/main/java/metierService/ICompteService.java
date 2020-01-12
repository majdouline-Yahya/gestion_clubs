package metierService;

import java.util.Collection;

import entities.Compte;

public interface ICompteService {
   
	Collection<Compte> findAll();
	Collection<Compte> findByLogin(String login);
	Compte findOne(Long id);
	Compte create(Compte compte);
	Compte update(Compte compte);
	void delete(Long id);
}
