package usermetier;

import java.util.List;

import fr.doranco.control.impl.UserMetier;
import fr.doranco.entity.Adresse;
import fr.doranco.entity.User;
import fr.doranco.model.dao.impl.UserDao;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.utils.Cryptage;
import fr.doranco.utils.DataTest;
import fr.doranco.utils.Dates;
import fr.doranco.utils.Utils;

public class TUserMetierRead {

	public static void main(String[] args) {

		lectureMail();

	}

//==================================================================================================
	public static void lectureMail() {
		try {
			IUserDao userDao = new UserDao();
			User user = userDao.getUserByEmail("juliette.nicolas@amelanchier.us");
			if (user != null) {
				Utils.trace("user %s\n", user);
				Utils.trace("profession : %s\n", user.getProfil().getName());
			} else
				Utils.trace("user nnull ");

//			for (Adresse a : user.getAdresses()) {
//				System.out.println("  -> " + a);
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ==================================================================================================
	public static void lecture() {
		try {
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(4);

			System.out.println(user);
//			for (Adresse a : user.getAdresses()) {
//				System.out.println("  -> " + a);
//			}

			System.out.println("========================");
			List<User> users = userDao.getUsers();
			for (User u : users) {
				System.out.println(u);
//				for (Adresse a : u.getAdresses()) {
//					System.out.println("  -> " + a);
//				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
