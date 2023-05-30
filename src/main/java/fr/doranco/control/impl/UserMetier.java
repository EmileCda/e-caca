package fr.doranco.control.impl;

import java.util.List;

import fr.doranco.control.interfaces.IUserMetier;
import fr.doranco.entity.User;
import fr.doranco.model.dao.interfaces.IUserDao;
import fr.doranco.model.dao.impl.UserDao;

public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public User addUser(User user) throws Exception {
		if (user == null) {
			throw new NullPointerException("Le user à créer ne doit pas être null !");
		}
		user.setNom(user.getNom().toUpperCase());
		user.setPrenom(user.getPrenom().substring(0, 1).toUpperCase()
						.concat(user.getPrenom().substring(1).toLowerCase()));
		return userDao.addUser(user);
	}

	@Override
	public List<User> getUsers() throws Exception {
		return userDao.getUsers();
	}

	@Override
	public void deleteUser(User user) throws Exception {
		userDao.deleteUser(user.getId());
		
	}

}
