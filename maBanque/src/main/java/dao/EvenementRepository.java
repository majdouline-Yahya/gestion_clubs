package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Evenement;


public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	/*@Query("select u from User u where u.emailAddress = ?1")
	  User findByEmailAddress(String emailAddress);*/
	  //@Query("select c from Evenement c where c.Theme =:theme")
	@Query(value = "SELECT c FROM Evenement c  where c.Theme = ?1 ")
	    List<Evenement> findByTheme( String theme);
	  
	  @Query("select c from Evenement c where c.Description =:description ")
	    List<Evenement> findByDescription(@Param("description") String description);

}
