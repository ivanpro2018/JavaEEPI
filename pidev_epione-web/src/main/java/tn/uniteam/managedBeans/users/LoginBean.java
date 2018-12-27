package tn.uniteam.managedBeans.users;

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
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private AspNetUser user;
	@EJB
	private UserManagementLocal uml;
	
	public String doLogin(){
		String redirectionPage = null;
		user = uml.loginUser(login, password);
		if(user != null) {
			redirectionPage = "welcome?faces-redirect=true";
		}
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Login ou mot de passe incorrects!"));
			return redirectionPage;
		}		
		
		return redirectionPage;
	}

	public String doGoToReport(){
		System.out.println("okkk");
			return "/analytics/compterendu?faces-redirect=true";
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

	public AspNetUser getUser() {
		return user;
	}

	public void setUser(AspNetUser user) {
		this.user = user;
	}

	public LoginBean() {
		super();
	}
	

}
