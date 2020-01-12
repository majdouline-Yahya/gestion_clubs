package dao;


import java.util.Collection;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Club;
import entities.Evenement;
import entities.membreAdherant;


public interface EvenementRepository extends JpaRepository<Evenement, Long>{

	//@Query(value="SELECT * FROM candidature where id_club = ?1",nativeQuery=true)
	  @Query(value = "SELECT * FROM Evenement  where theme = ?1 ",nativeQuery=true)
	    List<Evenement> findByTheme( String theme);
	  
	  @Query(value= "SELECT * FROM Evenement where description = ?1",nativeQuery=true)
	    List<Evenement> findByDescription( String description);
	  
	  /*@Query(value= "SELECT * FROM evenement_clubs where id_club = ?1",nativeQuery=true)
	    List<Evenement> findEventsByClub( Long idClub);*/
	  
	  @Query(value= "SELECT * FROM evenement_clubs where id_event = ?1",nativeQuery=true)
	    List<Long> findClubsOfEvent( Long idEvent);
	  
	 
	
	  
	  
	  
	  
	  


}
