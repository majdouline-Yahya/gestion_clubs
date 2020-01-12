package dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	// @Query(value = "SELECT * FROM Evenement  where theme = ?1 ",nativeQuery=true)
	 @Query(value = "SELECT * FROM Compte where login = ?1 ",nativeQuery=true)
	    Collection<Compte> findByLogin( String login); 
}
