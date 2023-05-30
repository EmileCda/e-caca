package fr.doranco.view.beans;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.control.impl.UserMetier;
import fr.doranco.control.interfaces.IUserMetier;
import fr.doranco.entity.User;
import fr.doranco.model.dao.impl.UserDao;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.utils.Utils;

@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{adressebean}")
	private static AdresseBean adresseBean;

	@ManagedProperty(name = "genre", value = "M.")
	private String genre;

	@ManagedProperty(name = "prenom", value = "Michel")
	private String prenom;

	@ManagedProperty(name = "nom", value = "DUPOND")
	private String nom;

	private Date dateNaissance;

	@ManagedProperty(name = "email", value = "michel.dupont@doranco.fr")
	private String email;

	private String password;
	private String passwordConfirmation;
	private String messageSuccess;
	private String messageError;

	private final IUserMetier userMetier = new UserMetier();

	public UserBean() {
		messageSuccess = "";
		messageError = "";
	}

	public List<User> getUsers() {
		try {
			return userMetier.getUsers();
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la récupération de la liste des utilisateurs !\n" + e.getMessage();
			e.printStackTrace();
			return null;
		}
	}

	public String addUser() {

		try {
			if (!password.equals(passwordConfirmation)) {
				messageError = "Les deux mots de passe ne correspondent pas ! Veuillez réessayer.";
				messageSuccess = "";
				return "";
			}

			User user = new User();
			user.setNom(nom);
			user.setPrenom(prenom);
			user.setDateNaissance(dateNaissance);
			user.setEmail(email);
			user.setPassword(password);

//			adresseBean.getAdresses().forEach(a -> user.getAdresses().add(a));

			User addedUser = userMetier.addUser(user);

			messageSuccess = "Compte créé avec succès.";
			messageError = "";
//			adresseBean.getAdresses().clear();
//			adresseBean.initializeAdresse();
			initializeUser();

			// return "";
			return "login-utilisateur.xhtml";

		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la création de l'utilisateur !\n" + e.getMessage();
			e.printStackTrace();
			return "";
		}
	}

	public void deleteUser(User user) {
		try {
			userMetier.deleteUser(user);
			messageSuccess = "Utilisateur supprimé avec succès.";
			messageError = "";
		} catch (Exception e) {
			messageSuccess = "";
			messageError = "Erreur lors de la suppression de l'utilisateur !\n" + e.getMessage();
			e.printStackTrace();
		}
	}

	private void initializeUser() {
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.genre = "";
		this.dateNaissance = null;
	}

	public AdresseBean getAdresseBean() {
		return adresseBean;
	}

	public void setAdresseBean(AdresseBean adresseBean) {
		this.adresseBean = adresseBean;
	}

	public String connect() {

//		COSTUMER("Costumer", 0), MANAGER("Admin", 1), STORE_KEEPER("magasinier", 2)
		User user = null;
		Utils.trace("***********%s\n", user);
		try {
		

			IUserDao userDao = new UserDao();
			user = userDao.getUserByEmail(this.getEmail());
			Utils.trace("%s\n", user);
			if (user == null)
				return null;
			Utils.trace("%s\n", user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		Utils.trace("%s %d \n", user, user.getProfil().getId());

		switch (user.getProfil().getId()) {

		case 0:
			return "gestion-achats.xhtml";
		case 1:
			return "gestion-admin.xhtml";
		default:
			return "gestion-articles.xhtml";

		}
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
