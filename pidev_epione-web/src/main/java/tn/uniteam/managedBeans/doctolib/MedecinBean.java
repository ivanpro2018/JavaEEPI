package tn.uniteam.managedBeans.doctolib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.services.doctolib.MedecinServicesLocal;

@ManagedBean
@SessionScoped
public class MedecinBean implements Serializable{
	private String id; 
	private String address; 
	private int age;
	private String firstName; 
	private String lastName; 

	private List<AspNetUser> listemed=new ArrayList<AspNetUser>();
	private AspNetUser user =new AspNetUser();
	@PersistenceContext
	EntityManager em;
	@EJB
	private MedecinServicesLocal medecinServiceLocal;
	


	
	
	


	


	public List<AspNetUser> getListemed() {
		return listemed;
	}

	public void setListemed(List<AspNetUser> listemed) {
		this.listemed = listemed;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	
	
	public void doAdd()
	{
		medecinServiceLocal.addUser(user);
	}
	
	public void removeUser(String id) {
		medecinServiceLocal.deleteUserr(id);
	}
	
	
	public void updateUser(AspNetUser user){
		 id=user.getId();
		 address=user.getAddress();
		 age=user.getAge();
		 firstName=user.getFirstName();
		 lastName=user.getLastName();
	}

	public AspNetUser getUser() {
		return user;
	}


	public void setUser(AspNetUser user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
}
