package pidev_tests;



import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.AspNetUser.Gender;
import tn.uniteam.services.userservices.UserManagementRemote;

public class TestUserManagement {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context ctx = new InitialContext();
		String jndiName = "pidev_epione-ear/pidev_epione-ejb/UserManagement!tn.uniteam.services.userservices.UserManagementRemote";
		UserManagementRemote proxy = (UserManagementRemote) ctx.lookup(jndiName);
		AspNetUser a = new AspNetUser();
		a.setUserName("Ivanoos");
		a.setId("kjfkjjkjdefeffjkkj");
		a.setEmailConfirmed(true);
		a.setLockoutEnabled(true);
		a.setDiscriminator("patient");
		a.setPhoneNumberConfirmed(false);
		a.setAccessFailedCount(0);
		a.setTwoFactorEnabled(false);
		a.setGender(Gender.female);
		Date d = new Date();
		a.setBirthDate(d);
		
		
		try {
			AspNetUser u = proxy.searchUser("kjfkjjkjdefeffjkkj");
			System.out.println("User trouvé! "+u);
			proxy.deleteUser(u);	
			System.out.println("User retiré!");
			proxy.addUser(a);	
			System.out.println("User ajouté!");
			a.setUserName("Polios");
			proxy.updateUser(a);	
			System.out.println("User modifié!");
			System.out.println(proxy.getAllUsers());
			System.out.println("OK!!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		

	}

}
