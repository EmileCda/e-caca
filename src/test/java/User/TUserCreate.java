package User;

import fr.doranco.entity.User;
import fr.doranco.utils.Dates;

public class TUserCreate {

	public static void main(String[] args) {
		
		
		User user = initUser();
		System.out.println(user);
		
	}

//-------------------------------------------------------------------------------------------------	
	public static User initUser() {
		User user = new User();
		try {
			user.setDateNaissance(Dates.convertStringToDate("14/07/2001"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setEmail("azerty@durucul.com");
		user.setId(0);
		user.setNom("Napoléon");
		user.setPassword("mot-secret");
		user.setPrenom("jean-jean");
		user.setTelephone("0136153617");
		
		System.out.println(user);
		return user ; 
	}
}
