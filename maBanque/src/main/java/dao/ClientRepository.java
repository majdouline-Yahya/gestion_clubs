package dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Evenement;
import entities.TeamLeader;
import entities.Utilisateur;
//pour gerer les clients
public interface ClientRepository extends JpaRepository<Utilisateur, Long> {

	  @Query(value = "SELECT * FROM utilisateur  where email = ?1 ",nativeQuery=true)
	    Utilisateur findByMail( String email);
	  
	  @Query(value = "SELECT * FROM utilisateur  where email = ?1 ",nativeQuery=true)
	    TeamLeader findByMailT( String email);
	  
	  @Query(value = "SELECT role FROM utilisateur where  id_user=?1 ",nativeQuery=true)
	    String findRoleOfUser(Long idUser);
	  
	  @Query(value = "Update utilisateur SET role=?1  where  id_user=?2 ",nativeQuery=true)
	    void UpdateRoleOfUser(String role,Long idUser );
	  
	  @Query(value = "DELETE * FROM membres_club where id_user=?1 ",nativeQuery=true)
	    void deleteFromMembresClub(Long idUser );
	  
	  @Query(value = "SELECT id_club FROM membres_clubs where id_user=?1 ",nativeQuery=true)
	    Collection<Long> findClubOfUser(Long idUser);
}
