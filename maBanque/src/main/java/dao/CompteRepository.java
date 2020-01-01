package dao;

import org.springframework.data.jpa.repository.JpaRepository;



import entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

}
