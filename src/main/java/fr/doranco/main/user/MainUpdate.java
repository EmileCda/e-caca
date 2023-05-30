package fr.doranco.main.user;

import fr.doranco.entity.User;
import fr.doranco.model.dao.impl.UserDao;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.utils.Dates;

public class MainUpdate {

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(2);
			user.setNom("HUGO");
			user.setPrenom("Victor");
			user.setDateNaissance(Dates.convertStringToDate("21/03/1956"));
			userDao.updateUser(user);
			System.out.println("Mise à jour réussie");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
