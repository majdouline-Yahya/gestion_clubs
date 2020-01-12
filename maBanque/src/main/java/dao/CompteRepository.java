package dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Compte;
import entities.Utilisateur;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	
	 @Query(value = "SELECT * FROM Compte where login = ?1 ",nativeQuery=true)
	    Collection<Compte> findByLogin( String login); 
	 
	 @Query(value = "SELECT * FROM Compte where login = ?1 and password= ?2 ",nativeQuery=true)
	    Compte verifyLogin( String login,String password); 
}
