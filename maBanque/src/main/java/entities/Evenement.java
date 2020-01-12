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

@Entity
public class Evenement implements Serializable {
    
	@Id @GeneratedValue
	private Long idEvent;
	private String  titre;
	private String Description;
	private String Theme;
	private String lieu;
	private Date dateDebut;
	private Date dateFin;
	 @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "evenement_clubs",
            joinColumns = { @JoinColumn(name = "idEvent") },
            inverseJoinColumns = { @JoinColumn(name = "idClub") })
    private Collection<Club> clubs ;
	
	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evenement(String titre,String description, String theme, String lieu, Date dateDebut, Date dateFin, Set<Club> clubs) {
		super();
		Description = description;
		Theme = theme;
		this.lieu = lieu;
		this.titre = titre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	
		this.clubs = clubs;
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTheme() {
		return Theme;
	}

	public void setTheme(String theme) {
		Theme = theme;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Collection<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Collection<Club> clubs) {
		this.clubs = clubs;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	
	
	
	
	
}
