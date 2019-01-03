package tn.uniteam.managedBeans.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.services.userservices.UserManagementLocal;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String msg = null;
	private String patientName;
	private String UserId;
	private AspNetUser user;
	public static AspNetUser loggedUser;
	@EJB
	private UserManagementLocal uml;
	
	public String doLogin(){
		String redirectionPage = "";
		user = new AspNetUser();
		user.setUserName(login);
		user.setPasswordHash(password);
		String connxion = uml.loginUser(user);
		
		if(connxion.equals("\"ConnexionSuccess\"")) {
			redirectionPage = "index?faces-redirect=true";
		}
		else {
			FacesMessage msg = new FacesMessage( "Login ou mot de passe incorrects!" );
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			redirectionPage = "LoginUser.xhtml?faces-redirect=true";
			return redirectionPage;
		}		
		
		return redirectionPage;
	}
	
	public String doLoginDash(){
		String redirectionPage = null;
		user = uml.loginUser(login);
		if(user != null && user.getDiscriminator().equals("Doctor")) {
			System.out.println("Logged!");
			redirectionPage = "../dashboard/index.jsf";
			System.out.println(redirectionPage);
			loggedUser = user;
		}
		else if (!user.getDiscriminator().equals("Doctor")) {
			System.out.println("HALT!!!!");
//			FacesContext.getCurrentInstance().addMessage("form:butn", new FacesMessage("Access denied !"));
			msg = "Access denied !";
		}
		else {
			System.out.println("ERROORR!!!!");
//			FacesContext.getCurrentInstance().addMessage("form:butn", new FacesMessage("Invalid creditentials!"));
			msg = "Invalid creditentials !";
		}		
		return redirectionPage;
		
	}

	public List<AspNetUser> doListPatients() {
		return uml.getAllPatients();
	}
	
	public List<AspNetUser> doListDoctors() {
		return uml.getOthersDoctors(loggedUser);
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public AspNetUser getUser() {
		return user;
	}

	public void setUser(AspNetUser user) {
		this.user = user;
	}

	public AspNetUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(AspNetUser loggedUser) {
		this.loggedUser = loggedUser;
	}

	public LoginBean() {
		super();
	}
	

}
