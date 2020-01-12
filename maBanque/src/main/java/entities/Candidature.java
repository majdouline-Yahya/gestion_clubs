package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Candidature implements Serializable {
	
	@Id @GeneratedValue
	private Long idCandidature ;
	@ManyToOne
	@JoinColumn(name="idUser")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name="idClub")
	private Club club;
	private String motivation;
	private String skills;
	private Date dateCandidature;
	
	
	public Candidature() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Candidature(Utilisateur utilisateur, Club club, String motivation, String skills, Date dateCandidature) {
		super();
		this.utilisateur = utilisateur;
		this.club = club;
		this.motivation = motivation;
		this.skills = skills;
		this.dateCandidature = dateCandidature;
	}


	public Long getIdCandidature() {
		return idCandidature;
	}


	public void setIdCandidature(Long idCandidature) {
		this.idCandidature = idCandidature;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public String getMotivation() {
		return motivation;
	}


	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public Date getDateCandidature() {
		return dateCandidature;
	}


	public void setDateCandidature(Date dateCandidature) {
		this.dateCandidature = dateCandidature;
	}
	
	

}
