package tn.uniteam.managedBeans.analytics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import tn.uniteam.managedBeans.users.LoginBean;
import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Repport;
import tn.uniteam.services.analytics.RepportManagement;
import tn.uniteam.services.analytics.RepportManagementLocal;
import tn.uniteam.services.userservices.UserManagementLocal;

@ManagedBean
@ViewScoped
public class CompteRenduBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private RepportManagementLocal rml = new RepportManagement();
	private Repport report = new Repport();
	private String error = "";
	private AspNetUser doctor = LoginBean.loggedUser;
	private Part picDisease;
	private Repport selectedReport;
	private HttpServletRequest req;
	
	public String doGoToReport(){
			return "/analytics/sent_repports?faces-redirect=true";
	}
	
	public List<Repport> doListSentRepports() {
		return rml.getAllSentReports(doctor);
	}
	
	public List<Repport> doListReceivedRepports() {
		return rml.getAllReceivedReports(doctor);
	}
	
		
	public void doUpload() {
		try {
			InputStream in = picDisease.getInputStream();
			String pathname = "C:\\Users\\ivano\\Documents\\GitHub\\JavaEEPI\\pidev_epione-web\\src\\main\\webapp\\resources\\upload\\";
			File pic = new File(pathname + picDisease.getSubmittedFileName());
//			System.out.println(picDisease.getSubmittedFileName());
			pic.createNewFile();
			FileOutputStream picOut = new FileOutputStream(pic);
			byte[] buffer = new byte[1024]; //1073741824 - 3145728
			int length;
			while ((length=in.read(buffer))>0) {
				picOut.write(buffer, 0, length);				
			}
			report.setImageDisease(picDisease.getSubmittedFileName());
			picOut.close();
			in.close();
			picDisease.write(pathname+picDisease.getSubmittedFileName());
//			System.out.println("Okay");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur image : " );
			e.printStackTrace(System.out);
		}
	}
	
    public void buttonAction(String name) {
        addMessage("Your report has been sent to Dr. "+name);
    }
 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	
	public String doSendReport() throws ServletException,IOException {
		try {
			req = null;
			doUpload();
			report.setAspNetUser(doctor);
			rml.sendReport(report);
//			if(req.getParameter("notif") != null) {
//				System.out.println("True : checked");
//			} else {
//				System.out.println("False : !!unchecked");
//			}
			buttonAction(report.getReferentDoctor());
			return "/analytics/sent_repports?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.error = e.getMessage();
			System.out.println("Erreur envoi : " + error);
			return null;
		}		
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public AspNetUser getDoctor() {
		return doctor;
	}

	public void setDoctor(AspNetUser doctor) {
		this.doctor = doctor;
	}

	public Part getPicDisease() {
		return picDisease;
	}

	public void setPicDisease(Part picDisease) {
		this.picDisease = picDisease;
	}

	public Repport getReport() {
		return report;
	}

	public void setReport(Repport r) {
		this.report = r;
	}

	public Repport getSelectedReport() {
		return selectedReport;
	}

	public void setSelectedReport(Repport selectedReport) {
		this.selectedReport = selectedReport;
	}
	
	

}
