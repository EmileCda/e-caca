package usermetier;


import fr.doranco.entity.User;
import fr.doranco.model.dao.impl.UserDao;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.utils.DataTest;
import fr.doranco.utils.Dates;
import fr.doranco.utils.Utils;

public class TUserMetierUpdate {

	public static void main(String[] args) {
		
		IUserDao userDao = new UserDao();
		User user = null;
		try {
			user = userDao.getUserById(8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Utils.trace("avant %s\n", user);
		
		user.setPassword("a");
		
		 try {
			userDao.updateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 Utils.trace(" apres %s\n", user);
		
	}
	

}
