package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("membre")
public class membreAdherant extends Utilisateur {
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "membres_clubs",
            joinColumns = { @JoinColumn(name = "idUser") },
            inverseJoinColumns = { @JoinColumn(name = "idClub") })
    private Set<Club> clubs = new HashSet<>();
	public membreAdherant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public membreAdherant(String nom, String email, Integer age) {
		super(nom, email, age);
		// TODO Auto-generated constructor stub
	}

	
}
