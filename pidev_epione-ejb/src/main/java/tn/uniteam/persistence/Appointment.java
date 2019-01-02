package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Appointments database table.
 * 
 */
@Entity
@Table(name="Appointments")
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AppointmentId")
	private int AppointmentId;

	@Column(name="AppointmentState")
	private int AppointmentState;

	@Column(name="Date")
	private Date Date;

	@Column(name="Location")
	private String Location;

	@Column(name="Specialities")
	private int Specialities;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="DoctorId")
	private AspNetUser AspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="PatientId")
	private AspNetUser AspNetUser2;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="appointment")
	private List<Rate> Rates;

	public Appointment() {
	}


	public int getAppointmentId() {
		return AppointmentId;
	}


	public void setAppointmentId(int appointmentId) {
		AppointmentId = appointmentId;
	}


	public int getAppointmentState() {
		return AppointmentState;
	}


	public void setAppointmentState(int appointmentState) {
		AppointmentState = appointmentState;
	}


	public Date getDate() {
		return Date;
	}


	public void setDate(Date date) {
		Date = date;
	}


	public String getLocation() {
		return Location;
	}


	public void setLocation(String location) {
		Location = location;
	}


	public int getSpecialities() {
		return Specialities;
	}


	public void setSpecialities(int specialities) {
		Specialities = specialities;
	}


	public AspNetUser getAspNetUser1() {
		return AspNetUser1;
	}


	public void setAspNetUser1(AspNetUser aspNetUser1) {
		AspNetUser1 = aspNetUser1;
	}


	public AspNetUser getAspNetUser2() {
		return AspNetUser2;
	}


	public void setAspNetUser2(AspNetUser aspNetUser2) {
		AspNetUser2 = aspNetUser2;
	}


	public List<Rate> getRates() {
		return Rates;
	}


	public void setRates(List<Rate> rates) {
		Rates = rates;
	}


	public Rate addRate(Rate rate) {
		getRates().add(rate);
		rate.setAppointment(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setAppointment(null);

		return rate;
	}


	@Override
	public String toString() {
		return "Appointment [AppointmentId=" + AppointmentId + ", AppointmentState=" + AppointmentState + ", Date="
				+ Date + ", Location=" + Location + ", Specialities=" + Specialities + ", AspNetUser1=" + AspNetUser1
				+ ", AspNetUser2=" + AspNetUser2 + ", Rates=" + Rates + "]";
	}
	

}