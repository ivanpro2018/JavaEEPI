package pidev_tests;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.services.espacemedecin.DoctorManagementRemote;

public class TestAzza {

	public static void main(String[] args) throws NamingException {

		InitialContext ctx= new InitialContext();
		Object obj=ctx.lookup("pidev_epione-ear/pidev_epione-ejb/DoctorManagement!tn.uniteam.services.espacemedecin.DoctorManagementRemote");
		DoctorManagementRemote client=(DoctorManagementRemote) obj;
		client.Consommation();
	}

}
