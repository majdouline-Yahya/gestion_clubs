package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Evenement;
import entities.Utilisateur;
//pour gerer les clients
public interface ClientRepository extends JpaRepository<Utilisateur, Long> {

	  @Query(value = "SELECT * FROM utilisateur  where email = ?1 ",nativeQuery=true)
	    Utilisateur findByMail( String email);
	  
	  @Query(value = "SELECT role FROM utilisateur where  id_user=?1 ",nativeQuery=true)
	    String findRoleOfUser(Long idUser);
}
