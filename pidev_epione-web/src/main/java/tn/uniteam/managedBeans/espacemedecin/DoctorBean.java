package tn.uniteam.managedBeans.espacemedecin;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.AspNetUser.Gender;
import tn.uniteam.persistence.AspNetUser.Speciality;
import tn.uniteam.persistence.Disponibility;
import tn.uniteam.services.espacemedecin.DoctorManagement;
@ManagedBean
@SessionScoped
public class DoctorBean {
	private String address;
	private int age;
	private Date birthDate;	
	private String discriminator;
	private String email;
	private String firstName;	
	private Gender gender;
	private String imageName;
	private String lastName;
	private String phoneNumber;
	private Speciality speciality;
	private String username;
	@EJB
	DoctorManagement doctorManagement;
	/*
	public List<AspNetUser> getListeDoctors() {
		 List<AspNetUser> listeDoc=new ArrayList<AspNetUser>() ;
		for(int i=0;i<doctorManagement.ConsommationGetAllDoc().size();i++) {
			AspNetUser doc=new AspNetUser();
			doc.setFirstName(doctorManagement.ConsommationGetAllDoc().get(i).getFirstName());
			doc.setLastName(doctorManagement.ConsommationGetAllDoc().get(i).getLastName());
			doc.setId(doctorManagement.ConsommationGetAllDoc().get(i).getId());
			listeDoc.add(doc);
		}
		System.out.println(listeDoc.toString());
		return listeDoc;		
	
	
	public List<AspNetUser> ConsommationGetAllDoc() {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:54774/APIDoctor/getDoctors");
		//WebTarget details=target.path("9d8c6214-a26a-40f3-b370-e0e1a7984e91");
		Response response=target.request().get();
		List<AspNetUser> result=response.readEntity(List.class);
		System.out.println(result);
		
		return result;
}
	}*/
	public List<AspNetUser>lstm() throws IOException{
		Type listType = new TypeToken<ArrayList<AspNetUser>>(){}.getType();
		String webPage = "http://localhost:54774/APIDoctor/getDoctors";

		String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();

		System.out.println(data);
		System.out.println("ba3d el sys data");
		Gson g = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();

		//Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

		List<AspNetUser> pls = g.fromJson(data, listType);
		System.out.println(pls);
        
 
		System.out.println("hedhiiiii plss "+pls);
		        
		  return pls;
			}
	private List<Disponibility> ListeDispo;
	
	public String listeDispo(String idDoc) throws IOException{
		Type listType = new TypeToken<ArrayList<Disponibility>>(){}.getType();
		String webPage = "http://localhost:54774/APIDoctor/ViewDispo/"+idDoc;
		String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/30.0.1599.101 Safari/537.36";
		String data = Jsoup.connect(webPage).ignoreContentType(true).userAgent(userAgent).timeout(100000).method(Method.POST).execute().body();
		System.out.println("ba3d el sys data");
		Gson g = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
		List<Disponibility> pls = g.fromJson(data, listType);
		System.out.println(pls);
        setListeDispo(pls);
		System.out.println("hedhiiiii plss "+pls);
		return "/espacemedecin/ShowDisponibilities.xhtml?faces-redirect=true";      
		 
			}

  public List<Disponibility> AfficherDispo(){
	  System.out.println(getListeDispo());
	  return getListeDispo();
  }
	public List<Disponibility> getListeDispo() {
		return ListeDispo;
	}


	public void setListeDispo(List<Disponibility> listeDispo) {
		ListeDispo = listeDispo;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getDiscriminator() {
		return discriminator;
	}
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
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
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
