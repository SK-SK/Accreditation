package ma.educ.accreditation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	//bi-directional many-to-one association to Coordinateur
	@OneToMany(mappedBy="grade")
    @JsonBackReference(value="cord-grade")
	private List<Coordinateur> coordinateurs;

	

	public List<Coordinateur> getCoordinateurs() {
		return coordinateurs;
	}

	public void setCoordinateurs(List<Coordinateur> coordinateurs) {
		this.coordinateurs = coordinateurs;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
/*

	public void setId(int id) {
		this.id = id;
	}
*/

	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
