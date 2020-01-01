package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity

public abstract class Compte implements Serializable{
	@Id @GeneratedValue
	private Long idCompte;
	private String login;
	private String password;
	@ManyToOne
	@JoinColumn(name="idUser")
	private Utilisateur utilisateur;
	
	
	
	
	
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte( String login, String password, Utilisateur utilisateur) {
		super();
		
		this.login = login;
		this.password = password;
		this.utilisateur = utilisateur;
	}

	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
  
	
	

}
