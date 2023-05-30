package usermetier;

import fr.doranco.control.impl.UserMetier;
import fr.doranco.entity.User;
import fr.doranco.enums.Profil;
import fr.doranco.utils.Cryptage;
import fr.doranco.utils.DataTest;
import fr.doranco.utils.Dates;
import fr.doranco.utils.Utils;

public class TUserMetierCreate {

	public static void main(String[] args) {
		
		UserMetier  usermetier = new UserMetier();
		User user = new User();
		User user1 = new User();
		user = initUser();
		try {
			user1=usermetier.addUser(user);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		System.out.println(user);
		System.out.println(user1);
		
	}
	
	
	
	public static User initUser() {
		User user = new User();
		try {
			user.setDateNaissance(Dates.convertStringToDate("14/07/2001"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		user.setId(0);
		user.setNom(DataTest.lastname());
		user.setPrenom(DataTest.firstname());
		user.setPassword(user.getPrenom());
		user.setEmail(DataTest.email(user.getPrenom(),user.getNom()));
		user.setTelephone(DataTest.phone());
		user.setProfil(Profil.values()[Utils.randInt(0, 2)]);
		
//		System.out.println(user);
		return user ; 
	}
}
