package dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Club;
import entities.membreAdherant;


public interface ClubRepository extends JpaRepository<Club, Long> {

	//chercher un club par intitulé
	@Query(value="SELECT c FROM Club c WHERE LOWER(c.intitule)=LOWER(:intitule)")
	public List<Club> consultByIntitule(@Param("intitule")String intitule);

	//all club members
	@Query(value="SELECT * FROM membres_clubs where id_club = ?1",nativeQuery=true)
	public Collection<membreAdherant> TousMembres(Long id);

}
