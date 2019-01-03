package pidev_tests;



import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.services.doctolib.MedecinServicesRemote;




public class TestMedecinManagement {

	public static void main(String[] args)  throws NamingException{
		// TODO Auto-generated method stub

		//AspNetUser u1=new AspNetUser("21","ariana",21,"ahmed","desri");
		AspNetUser u2=new AspNetUser("27","ariana",30,"cheikha","d");
		AspNetUser u3=new AspNetUser("55","tunis",32,"me","dd");

		Context context=new InitialContext();
		String jndiName="pidev_epione-ear/pidev_epione-ejb/MedecinServices!tn.uniteam.services.doctolib.MedecinServicesRemote";
		MedecinServicesRemote proxy=( MedecinServicesRemote) context.lookup(jndiName);
         


		proxy.addUser(u2);
		proxy.addUser(u3);
		
		List<AspNetUser> lists=proxy.getAllUsers();
		System.out.print(lists);
		//User u=proxy.Login("aa", "aa");
		//System.out.print(u);
	}

}
