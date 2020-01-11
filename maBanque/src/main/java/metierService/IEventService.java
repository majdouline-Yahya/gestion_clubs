package metierService;

import java.util.Collection;

import entities.Evenement;

public interface IEventService {
	Collection<Evenement> findAll();
	Evenement findOne(Long id);
	Evenement create(Evenement evenement);
	Evenement update(Evenement evenement);
	void delete(Long id);
}
