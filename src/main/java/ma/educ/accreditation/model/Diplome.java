package ma.educ.accreditation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="diplome")
public class Diplome {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String code;

	private int duree;

	private String libelle;

	@Column(name="tronc_commun_requis")
	private String troncCommunRequis;
	
	//bi-directional many-to-one association to Coordinateur
	@OneToMany(mappedBy="diplome")
	@JsonBackReference(value="cord-diplome")
	
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


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getTroncCommunRequis() {
		return troncCommunRequis;
	}

	public void setTroncCommunRequis(String troncCommunRequis) {
		this.troncCommunRequis = troncCommunRequis;
	}
	
	
}
