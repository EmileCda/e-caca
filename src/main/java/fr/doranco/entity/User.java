package fr.doranco.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.doranco.enums.Profil;

@Entity
@NamedQueries({
	@NamedQuery(name = "User:findAll", query = "FROM User u"),
	@NamedQuery(name = "User:findByEmail", query = "FROM User u WHERE u.email = :email")
	})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@NotEmpty
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;

	@NotEmpty
	@Column(name = "prenom", length = 30, nullable = false)
	private String prenom;

	@NotNull
	@Column(name = "date_naissance", length = 30, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@NotEmpty
	@Column(name = "email", unique = true, length = 30, nullable = false)
	private String email;

	private String password;

	@NotEmpty
	@Column(name = "telephone", length = 15, nullable = false)
	@Size(min = 10, max = 15)
	private String telephone;
	
	private Profil profil ; 
	
	
	
	
	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Adresse> adresses;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commande> commandes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<CartePaiement> cartePaiements;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<ArticlePanier> panier;

	public User() {
		this.adresses = new ArrayList<Adresse>();
		this.commandes = new ArrayList<Commande>();
		this.cartePaiements = new ArrayList<CartePaiement>();
		this.commentaires = new ArrayList<Commentaire>();
		this.panier = new ArrayList<ArticlePanier>();
		
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", profil=" + getProfil().getName() + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", password=" + password + ", telephone=" + telephone ; 
	}

}
