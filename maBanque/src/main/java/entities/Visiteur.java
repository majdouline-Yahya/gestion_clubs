package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("visiteur")
public class Visiteur extends Utilisateur {

	public Visiteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visiteur(String nom, String email, Integer age) {
		super(nom, email, age);
		// TODO Auto-generated constructor stub
	}

	
	
}
