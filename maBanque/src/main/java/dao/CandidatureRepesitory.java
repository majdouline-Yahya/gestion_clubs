package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Candidature;

public interface CandidatureRepesitory extends JpaRepository<Candidature, Long> {

}
