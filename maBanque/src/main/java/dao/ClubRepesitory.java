package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Club;


public interface ClubRepesitory extends JpaRepository<Club, Long> {

}
