package hasa.hafia.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Candidat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private int experience;
	private String Disponibilite;
	private Date date;
	private String niveauEtude;
	private String motivation;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "candidat_offre",
			joinColumns = {@JoinColumn(name="idC",nullable = false,updatable=false)},
			inverseJoinColumns = {@JoinColumn(name="idO",nullable = false,updatable=false)})
	private List<Offre> offre = new ArrayList<Offre>();

	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidat(int id, String nom, String prenom, int experience, String disponibilite, Date date,
			String niveauEtude, String motivation, List<Offre> offre) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.experience = experience;
		Disponibilite = disponibilite;
		this.date = date;
		this.niveauEtude = niveauEtude;
		this.motivation = motivation;
		this.offre = offre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDisponibilite() {
		return Disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		Disponibilite = disponibilite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public List<Offre> getOffre() {
		return offre;
	}

	public void setOffre(List<Offre> offre) {
		this.offre = offre;
	}

	}
