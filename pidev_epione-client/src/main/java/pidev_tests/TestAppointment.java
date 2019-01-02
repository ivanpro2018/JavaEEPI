package pidev_tests;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.services.espacepatient.AppointmentManagementLocal;
import tn.uniteam.services.espacepatient.AppointmentManagementRemote;



public class TestAppointment {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		InitialContext ctx= new InitialContext();
		Object obj=ctx.lookup("pidev_epione-ear/pidev_epione-ejb/AppointmentManagement!tn.uniteam.services.espacepatient.AppointmentManagementRemote");
		AppointmentManagementRemote client=(AppointmentManagementRemote) obj;
		
		System.out.println(client.ConsommationAppointmentsList().toString());
	}

}
