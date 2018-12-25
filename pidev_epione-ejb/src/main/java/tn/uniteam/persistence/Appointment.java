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
	private int appointmentId;

	@Column(name="AppointmentState")
	private int appointmentState;

	@Column(name="Date")
	private Date date;

	@Column(name="Location")
	private String location;

	@Column(name="Specialities")
	private int specialities;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="DoctorId")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="PatientId")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="appointment")
	private List<Rate> rates;

	public Appointment() {
	}

	public int getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getAppointmentState() {
		return this.appointmentState;
	}

	public void setAppointmentState(int appointmentState) {
		this.appointmentState = appointmentState;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSpecialities() {
		return this.specialities;
	}

	public void setSpecialities(int specialities) {
		this.specialities = specialities;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
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

}