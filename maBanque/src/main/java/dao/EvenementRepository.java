package dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Evenement;


public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	
	  @Query(value = "SELECT c FROM Evenement c  where c.Theme = ?1 ")
	    List<Evenement> findByTheme( String theme);
	  
	  @Query("select c from Evenement c where c.Description =:description ")
	    List<Evenement> findByDescription(@Param("description") String description);
	  
	  //SELECT person FROM Person person JOIN person.moviesActor movie
	  //select e  from Event e join e.participants u  where u.id = :userId and e.startDate > CURRENT_TIMESTAMP
	 /* @Query( value = "SELECT e FROM Evenement e join e.clubs ec  WHERE ec.idClub = ?1")
		Collection<Evenement> findAllEventsOfClub(Long id);
	 */ 
	  
	  
	  
	  
	  
	  

}
