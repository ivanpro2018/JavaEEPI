package pidev_tests;

import java.util.Calendar;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.persistence.Appointment;
import tn.uniteam.persistence.Reason;
import tn.uniteam.services.espacemedecin.DoctorManagementRemote;

public class TestAzza {

	public static void main(String[] args) throws NamingException {

		InitialContext ctx= new InitialContext();
		/*
		Object obj=ctx.lookup("pidev_epione-ear/pidev_epione-ejb/DoctorManagement!tn.uniteam.services.espacemedecin.DoctorManagementRemote");
		DoctorManagementRemote client=(DoctorManagementRemote) obj;
		System.out.println(client.ConsommationGetAllDoc());*/
		String jndiName ="pidev_epione-ear/pidev_epione-ejb/DoctorManagement!tn.uniteam.services.espacemedecin.DoctorManagementRemote";
		DoctorManagementRemote proxy = (DoctorManagementRemote) ctx.lookup(jndiName);
		/*
		Reason reason=new Reason();
		reason.setAspNetUser(proxy.getDoctorById("kjfkjjkjdefeffjkkj"));
		reason.setPrix(40);
		reason.setReasonContent("extraction");
	    proxy.addReason(reason);
	    System.out.println("reson added");
		Reason re=proxy.getReasonById(4);
	   System.out.println(re.toString());
		proxy.deleteReason(re);
		Appointment a1=new Appointment(0,new Date(2019,01,03,16,45,00),"boumhal",1,proxy.getDoctorById("9d8c6214-a26a-40f3-b370-e0e1a7984e91"),proxy.getDoctorById("5e4ae47d-6d90-45bb-b50d-7c61d0c4493a"));
		proxy.addAppointment(a1);
		System.out.println("app added");
		*/
		System.out.println(proxy.getNbAppByWeek("kjfkjjkjdefeffjkkj").get(0));
				Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int semaineDern=0;
		if (day-7<0)
			 semaineDern=(day-7+30);
		
	    System.out.println("year= "+year+" month= "+month+1+" day= "+day+" day of week in month: "+dayOfWeek+" demaine dernier "+semaineDern);
	
	}

}
