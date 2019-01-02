/**
 * 
 */
package tn.uniteam.managedBeans.appointments;


import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import tn.uniteam.persistence.Appointment;



/**
 * @author sirin
 *
 */
@ManagedBean(name="Appointment")
@SessionScoped

public class AppointmentBean  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int appointmentState;
	private Timestamp date;
	private String location;
	private int specialities;
	
	/**
	 * 
	 */
	
		public AppointmentBean() {
		// TODO Auto-generated constructor stub
	}
	
		public int getAppointmentState() {
		return appointmentState;
	}


	public void setAppointmentState(int appointmentState) {
		this.appointmentState = appointmentState;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getSpecialities() {
		return specialities;
	}


	public void setSpecialities(int specialities) {
		this.specialities = specialities;
	}

		private List<Appointment>Listappointment ;
		
		private List<Appointment> app;
		
		public List<Appointment> getListappointment() {
			return Listappointment;
		}


		public void setListappointment(List<Appointment> listappointment) {
			Listappointment = listappointment;
		}


		public List<Appointment> getApp() {
			return app;
		}


		public void setApp(List<Appointment> app) {
			this.app = app;
		}


		@PostConstruct
	    public void init() throws IOException {
		

	List<Appointment> list = new ArrayList<Appointment>();
	Type listType = new TypeToken<ArrayList<Appointment>>(){}.getType();


	String webPage = "http://localhost:54774/API/AppointmentsList";

	String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();

	System.out.println(data);

	Gson gson = new Gson();
	Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();





	ArrayList<Appointment> pls = g.fromJson(data, listType);
	System.out.println(pls);
	        


	    }

		
		public List<Appointment> Listappointment() throws IOException
		{
			
			
		List<Appointment> list = new ArrayList<Appointment>();
		Type listType = new TypeToken<ArrayList<Appointment>>(){}.getType();


		String webPage = "http://localhost:54774/API/AppointmentsList";

		String data = Jsoup.connect(webPage).ignoreContentType(true).execute().body();

		System.out.println(data);

		Gson gson = new Gson();
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
		List<Appointment> pls = g.fromJson(data, listType);
		System.out.println(pls);
		        
		  return pls;

		    }
		
		
		


	

}
