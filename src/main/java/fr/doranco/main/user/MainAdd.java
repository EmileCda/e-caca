package fr.doranco.main.user;

import fr.doranco.entity.User;
import fr.doranco.model.dao.impl.UserDao;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.utils.Dates;

public class MainAdd {

	public static void main(String[] args) {

		try {
			final IUserDao userDao = new UserDao();

			User user = new User("BLAISE", "Pascal", Dates.convertStringToDate("25/12/1960"));
			User addedUser = userDao.addUser(user);
			System.out.println(addedUser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
