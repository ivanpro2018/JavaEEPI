package pidev_tests;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.AspNetUser.Gender;
import tn.uniteam.services.espacepatient.PatientManagementLocal;
import tn.uniteam.services.espacepatient.PatientManagementRemote;


public class TestPatient {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		 String jndiName="pidev_epione-ear/pidev_epione-ejb/PatientManagement!tn.uniteam.services.espacepatient.PatientManagementRemote";
		 Context context =new InitialContext();
		 PatientManagementRemote proxy=(PatientManagementRemote) context.lookup(jndiName);
		 try {
			 AspNetUser a = new AspNetUser();
				a.setUserName("Sirine");
				a.setId("sirine123");
				a.setEmailConfirmed(true);
				a.setLockoutEnabled(true);
				a.setDiscriminator("patient");
				a.setPhoneNumberConfirmed(false);
				a.setAccessFailedCount(0);
				a.setTwoFactorEnabled(false);
				a.setGender(Gender.female);
				Date d = new Date();
				a.setBirthDate(d);
				System.out.println("je suis laa!!");
		proxy.addPoids(a.getId(), 55);
		proxy.getAllPatients();
		System.out.println("OK");
		} catch (Exception e) {
			System.out.println("cv pas !!");
		}
		
	}

}
