package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Utilisateur {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom, String email, Integer age) {
		super(nom, email, age);
		// TODO Auto-generated constructor stub
	}

	
	
}
