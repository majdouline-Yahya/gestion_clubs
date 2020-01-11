package metierService;

import java.util.Collection;

import entities.Evenement;

public interface IEventService {
	Collection<Evenement> findAll();
	Collection<Evenement> findByTheme(String theme);
	Collection<Evenement> findByDescription(String description);
	//Collection<Evenement> findEventsOfClub(Long idClub);
	Evenement findOne(Long id);
	Evenement create(Evenement evenement);
	Evenement update(Evenement evenement);
	void delete(Long id);
}
