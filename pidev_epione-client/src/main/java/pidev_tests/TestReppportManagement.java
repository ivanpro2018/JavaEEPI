package pidev_tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Repport;
import tn.uniteam.services.analytics.RepportManagementRemote;
import tn.uniteam.services.userservices.UserManagementRemote;

public class TestReppportManagement {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context ctx = new InitialContext();
		String jndiName = "pidev_epione-ear/pidev_epione-ejb/RepportManagement!tn.uniteam.services.analytics.RepportManagementRemote";
		String jndName2 = "pidev_epione-ear/pidev_epione-ejb/UserManagement!tn.uniteam.services.userservices.UserManagementRemote";
		
		UserManagementRemote proxy2 = (UserManagementRemote) ctx.lookup(jndName2);		
		RepportManagementRemote proxy = (RepportManagementRemote) ctx.lookup(jndiName);
		
		AspNetUser u = proxy2.searchUser("f5df33e1-162d-4217-9484-61bb7c84c705");
		System.out.println("User trouvé! "+u);
		
		Repport r = new Repport();		
		r.setRepportName("Compte rendu 1");
		proxy.sendReport(r);
		System.out.println("OK!");
		
		System.out.println(proxy.getAllSentReports(u));
		System.out.println("-----------------------------");
		System.out.println(proxy.getAllSentReports(u));
		

	}

}
