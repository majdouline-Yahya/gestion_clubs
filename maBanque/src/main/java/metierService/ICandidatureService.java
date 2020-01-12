package metierService;

import java.util.Collection;

import entities.Candidature;


public interface ICandidatureService {
	
	Collection<Candidature> findAll();
	Collection<Candidature> findByIdClub(Long idClub);
	Collection<Candidature> findByIdUser(Long idUser);
	Candidature findOne(Long idCandidature);
	Candidature create(Candidature candidature);
	Candidature update(Candidature candidature);
	void delete(Long id);
	boolean accept(Candidature candidature);

}
