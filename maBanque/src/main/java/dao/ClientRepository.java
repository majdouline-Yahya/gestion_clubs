package dao;

import org.springframework.data.jpa.repository.JpaRepository;


import entities.Utilisateur;
//pour gerer les clients
public interface ClientRepository extends JpaRepository<Utilisateur, Long> {

}
