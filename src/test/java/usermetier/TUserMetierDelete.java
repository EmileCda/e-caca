package usermetier;

import fr.doranco.control.impl.UserMetier;
import fr.doranco.entity.User;
import fr.doranco.model.dao.impl.UserDao;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.utils.Cryptage;
import fr.doranco.utils.DataTest;
import fr.doranco.utils.Dates;
import fr.doranco.utils.Utils;

public class TUserMetierDelete {

	public static void main(String[] args) {
		int userId = 4 ;
		try {
			IUserDao userDao = new UserDao();
			User user = userDao.getUserById(userId);
			 Utils.trace(" apres %s\n", user);
			
			userDao.deleteUser(userId);

			 user = userDao.getUserById(userId);
			 Utils.trace(" apres %s\n", user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
