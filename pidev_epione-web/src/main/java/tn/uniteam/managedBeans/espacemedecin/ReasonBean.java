package tn.uniteam.managedBeans.espacemedecin;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Reason;
import tn.uniteam.services.espacemedecin.DoctorManagement;
@ManagedBean
@SessionScoped
public class ReasonBean {
	private int reasonId;
	private float prix;
	private String reasonContent;
	private AspNetUser aspNetUser;
	
	private Reason reason=new Reason();
	@EJB
    DoctorManagement reasonManagement;
	
	 public List<Reason> getListeReasons() {
			return reasonManagement.getReasonsByDoctor("fc92be34-7fe8-4ab5-9fbf-d7d33742624a");		
		}
	 public String ajouterReason() {			
		 reason.setAspNetUser(reasonManagement.getDoctorById("fc92be34-7fe8-4ab5-9fbf-d7d33742624a"));			
			reasonManagement.addReason(reason);		
			return "/espacemedecin/ShowReason.xhtml?faces-redirect=true";
		}
	 public void supprimerReason(int id) {	 
		 reasonManagement.deleteReason(reasonManagement.getReasonById(id));
		 System.out.println("reason supprimer");
	 }
	 public String modifierReason(Reason r) {
		 this.setPrix(r.getPrix());
		 this.setReasonContent(r.getReasonContent());
		 this.setReasonId(r.getReasonId());
		 return "/espacemedecin/updateReason.xhtml?faces-redirect=true";
	 }
	 public String metreAjourReason() {
	    	System.out.println("avant update");
	    	AspNetUser d = reasonManagement.getDoctorById("fc92be34-7fe8-4ab5-9fbf-d7d33742624a");
	    	reasonManagement.updateReason(new Reason(this.getReasonId(),prix,reasonContent,d));
	        return "/espacemedecin/ShowReason.xhtml?faces-redirect=true";

	    }
	 
	
	public Reason getReason() {
		return reason;
	}
	public void setReason(Reason reason) {
		this.reason = reason;
	}
	public int getReasonId() {
		return reasonId;
	}
	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getReasonContent() {
		return reasonContent;
	}
	public void setReasonContent(String reasonContent) {
		this.reasonContent = reasonContent;
	}
	public AspNetUser getAspNetUser() {
		return aspNetUser;
	}
	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}
	
}
