package tn.uniteam.managedBeans.analytics;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.services.userservices.UserManagementLocal;

@ManagedBean
@SessionScoped
public class CompteRenduBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String doGoToReport(){
			return "analytics/compterendu?faces-redirect=true";
	}
	

}
