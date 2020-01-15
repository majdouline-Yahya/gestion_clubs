package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TeamLeader")
public class TeamLeader extends Utilisateur{

	public TeamLeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamLeader(String nom, String email, Integer age) {
		super(nom, email, age);
		// TODO Auto-generated constructor stub
	}
   
	
	
}
