package pidev_tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.persistence.Repport;
import tn.uniteam.services.analytics.RepportManagementRemote;

public class TestReppportManagement {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Context ctx = new InitialContext();
		String jndiName = "pidev_epione-ear/pidev_epione-ejb/RepportManagement!tn.uniteam.services.analytics.RepportManagementRemote";
		RepportManagementRemote proxy = (RepportManagementRemote) ctx.lookup(jndiName);
		
		Repport r = new Repport();
		
		r.setRepportName("Compte rendu 1");
		proxy.sendReport(r);
		System.out.println("OK!");

	}

}
