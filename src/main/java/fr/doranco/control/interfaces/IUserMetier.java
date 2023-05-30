package fr.doranco.control.interfaces;

import java.util.List;

import fr.doranco.entity.User;

public interface IUserMetier {

	User addUser(User user) throws Exception;
	List<User> getUsers() throws Exception;
	void deleteUser(User user) throws Exception;
}
