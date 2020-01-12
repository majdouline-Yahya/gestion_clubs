package metierService;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dao.EvenementRepository;
import entities.Club;
import entities.Evenement;

@Service
public class EventImpl implements IEventService {
    
	@Autowired
	public EvenementRepository evenementRepository;
	
	
	@Override
	public Collection<Evenement> findAll() {
		Collection<Evenement> evenements= evenementRepository.findAll();
		return evenements;
	}
    
	@Override
	public Evenement findOne(Long id) {
		Evenement evenement=null;
		try {
			evenement=evenementRepository.getOne(id);
			
		} catch (Exception e) {
				return null;
		}
		
		return evenement;
		 
	}
	
	@Override
	public Collection<Evenement> findByTheme(String theme) {
		Collection<Evenement> evenements= evenementRepository.findByTheme(theme);
		return evenements;
	}

	@Override
	public Collection<Evenement> findByDescription(String description) {
		Collection<Evenement> evenements= evenementRepository.findByDescription(description);
		return evenements;
	}
	@Override
	public Evenement create(Evenement evenement) {
		Evenement evenement2=evenementRepository.save(evenement);
		return evenement2;
	}

	@Override
	public Evenement update(Evenement evenement) {
		Evenement evenementUp=evenementRepository.getOne(evenement.getIdEvent());
		if(evenementUp==null)
		{
			return null;
		}
		Evenement evenementUpdated=evenementRepository.save(evenement);
		return evenementUpdated;
	}

	@Override
	public void delete(Long id) {
		Evenement evenement=evenementRepository.getOne(id);
		evenementRepository.delete(evenement);
		
	}

	@Override
	public Collection<Club> findClubsOfEvent(Long idEvent) {
		Evenement evenement= this.findOne(idEvent);
		Collection<Club> clubs=evenement.getClubs();
		
		return clubs;
	
	}



	

}
