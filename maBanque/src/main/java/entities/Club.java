package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "evenements", "membreAdherants"  })
@Entity

public class Club implements Serializable{

	@Id @GeneratedValue
	private Long idClub;
	private String intitule;
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="idTeamLeader")
	private TeamLeader teamLeader;
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "membres_clubs",
            joinColumns = { @JoinColumn(name = "idClub") },
            inverseJoinColumns = { @JoinColumn(name = "idUser") })
    private Set<membreAdherant> membreAdherants = new HashSet<>();
    
    
   /* @ManyToMany(mappedBy = "clubs", fetch = FetchType.LAZY)
    private Set<Evenement> evenements = new HashSet<>();*/
   @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "evenement_clubs",
            joinColumns = { @JoinColumn(name = "idClub") },
            inverseJoinColumns = { @JoinColumn(name = "idEvent") })
    private Collection<Evenement> evenements ;

	
	
	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}


	

    
	

	public Club(String intitule, Date dateCreation, TeamLeader teamLeader, Set<membreAdherant> membreAdherants,
			Set<Evenement> evenements) {
		super();
		this.intitule = intitule;
		this.dateCreation = dateCreation;
		this.teamLeader = teamLeader;
		this.membreAdherants = membreAdherants;
		this.evenements = evenements;
	}







	public Collection<Evenement> getEvenements() {
		return evenements;
	}



	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}


	public Long getIdClub() {
		return idClub;
	}


	public void setIdClub(Long idClub) {
		this.idClub = idClub;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public TeamLeader getTeamLeader() {
		return teamLeader;
	}


	public void setTeamLeader(TeamLeader teamLeader) {
		this.teamLeader = teamLeader;
	}


	public Set<membreAdherant> getMembreAdherants() {
		return membreAdherants;
	}



	public void setMembreAdherants(Set<membreAdherant> membreAdherants) {
		this.membreAdherants = membreAdherants;
	}


	
	
	
	
	
}
