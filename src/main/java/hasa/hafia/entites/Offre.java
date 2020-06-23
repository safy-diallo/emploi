package hasa.hafia.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Offre {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int id;
	private String nomEntreprise;
	private String titreposte;
	private String description;
	

	
	@ManyToMany (fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "offre")
	private List<Candidat> candidat = new ArrayList<Candidat>();

	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offre(int id, String nomEntreprise, String titreposte, String description,
			List<Candidat> candidat) {
		super();
		this.id = id;
		this.nomEntreprise = nomEntreprise;
		this.titreposte = titreposte;
		this.description = description;
		
		this.candidat = candidat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getTitreposte() {
		return titreposte;
	}

	public void setTitreposte(String titreposte) {
		this.titreposte = titreposte;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public List<Candidat> getCandidat() {
		return candidat;
	}

	public void setCandidat(List<Candidat> candidat) {
		this.candidat = candidat;
	}

	
	
}
