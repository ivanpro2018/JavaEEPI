package tn.uniteam.managedBeans.espacepatient;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.AspNetUser.Gender;
import tn.uniteam.services.espacepatient.PatientManagementLocal;
import tn.uniteam.services.userservices.UserManagementLocal;

@ManagedBean
@SessionScoped
public class PatientBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AspNetUser u=new AspNetUser();
	private int poids;
	private int taille;
	private String treatment;
	private String photo;
	private String id;
	private String Adresse;
	private int age;
	private String email;
	private String firstName;
	private Gender gender;
	private String lastName;
	private String phoneNumber;
	private String username;
	
	@EJB
	private PatientManagementLocal patientManagementLocal;
	private UserManagementLocal userManagementLocal;
	public PatientBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AspNetUser getU() {
		
		return u;
		
	}
	public void setU(AspNetUser u) {
		this.u = u;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public PatientManagementLocal getPatientManagementLocal() {
		return patientManagementLocal;
	}
	public void setPatientManagementLocal(PatientManagementLocal patientManagementLocal) {
		this.patientManagementLocal = patientManagementLocal;
	}
	public UserManagementLocal getUserManagementLocal() {
		return userManagementLocal;
	}
	public void setUserManagementLocal(UserManagementLocal userManagementLocal) {
		this.userManagementLocal = userManagementLocal;
	}
	public AspNetUser doGetUser()
	{
		String id="c9e056ce-d6e8-443a-aee8-f7700a75e276";
		AspNetUser p=patientManagementLocal.getPatient(id);
		return p;
		}

	public void doAdd(){
		userManagementLocal.addUser(u);
	}
	public void doAddPoids(){
		patientManagementLocal.addPoids(u.getId(), poids);
	}
	public void doAddTaille(){
		patientManagementLocal.addTaille(u.getId(), taille);
	}
	public void doAddTreatment() {
		patientManagementLocal.addTreatment(u.getId(), treatment);
	}
	public void doAddUserPhoto(){
		patientManagementLocal.addUserPhoto(u.getId(), photo);
	}
	public String doGetPhoto(AspNetUser p)
	{
		u=doGetUser();
		p=u;
		System.out.println("image name;"+p.getImageName());
		return p.getImageName();
	}
	public String doDeletePhoto(AspNetUser p)
	{
		u=doGetUser();
		p=u;
		patientManagementLocal.deleteUserPhoto(p.getId());
		return "Patient?faces-redirect=true";
	}
public String doUpdatePatient(AspNetUser p) {
	u=doGetUser();
	p=u;
	this.setId(p.getId());
	this.setAdresse(p.getAddress());
	this.setAge(p.getAge());
	this.setPhoto(p.getImageName());
	this.setPoids(p.getPoids());
	this.setTaille(p.getTaille());
	this.setTreatment(p.getTraitements());
	this.setUsername(p.getUserName());
	this.setEmail(p.getEmail());
	this.setFirstName(p.getFirstName());
	this.setLastName(p.getLastName());
	
		 System.out.println("recuperée");
		
		return "UpdatePatient?faces-redirect=true";

	}
//mettre a joours
	public String toUpdatePatient() {
		//u=doGetUser();
		patientManagementLocal.updatePatient(u);
		System.out.println(" update");
		
		return "Patient?faces-redirect=true";
	}
public double calculerIMC()
{AspNetUser u1=doGetUser();
double taille=u1.getTaille() * u1.getTaille();
System.out.println("taille"+taille);
    double imc = u1.getPoids() / taille;
    System.out.println(imc);
   
   return imc;
	}

public String getAdresse() {
	return Adresse;
}

public void setAdresse(String adresse) {
	Adresse = adresse;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

}
