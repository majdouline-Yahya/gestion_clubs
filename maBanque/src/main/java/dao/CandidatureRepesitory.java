package dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entities.Candidature;
import entities.Club;
import entities.membreAdherant;

public interface CandidatureRepesitory extends JpaRepository<Candidature, Long> {

		@Query(value="SELECT * FROM candidature where id_club = ?1",nativeQuery=true)
		public Collection<Candidature> candidaturesClub(Long idClub);
		
		@Query(value="SELECT * FROM candidature where id_user = ?1",nativeQuery=true)
		public Collection<Candidature> candidaturesUser(Long idUser);
}	
