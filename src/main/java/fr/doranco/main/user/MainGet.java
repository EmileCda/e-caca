package fr.doranco.main.user;

import java.util.List;

import fr.doranco.entity.Adresse;
import fr.doranco.entity.User;
import fr.doranco.model.dao.impl.UserDao;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.utils.Dates;

public class MainGet {

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(2);
			System.out.println(user);
			for (Adresse a : user.getAdresses()) {
				System.out.println("  -> " + a);
			}
			
			System.out.println("========================");
			List<User> users = userDao.getUsers();
			for (User u : users) {
				System.out.println(u);
				for (Adresse a : u.getAdresses()) {
					System.out.println("  -> " + a);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
