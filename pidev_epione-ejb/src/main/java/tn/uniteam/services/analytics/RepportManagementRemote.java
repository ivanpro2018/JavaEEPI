package tn.uniteam.services.analytics;

import java.util.List;

import javax.ejb.Remote;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Repport;

@Remote
public interface RepportManagementRemote {
	public void sendReport(Repport r);
	public List<Repport> getAllSentReports(AspNetUser doctor);
	public List<Repport> getAllReceivedReports(AspNetUser doctor);
	public void sendMail(String fromMail,String username,String password, String toMail,String subject,String message);
}
