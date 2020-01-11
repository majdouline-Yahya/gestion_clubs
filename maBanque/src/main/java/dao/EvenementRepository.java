package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Evenement;


public interface EvenementRepository extends JpaRepository<Evenement, Long>{

}
