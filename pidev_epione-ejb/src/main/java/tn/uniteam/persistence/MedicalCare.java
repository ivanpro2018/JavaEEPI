package tn.uniteam.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the MedicalCares database table.
 * 
 */
@Entity
@Table(name="MedicalCares")
@NamedQuery(name="MedicalCare.findAll", query="SELECT m FROM MedicalCare m")
public class MedicalCare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CareId")
	private int careId;

	@Column(name="CareDate")
	private Date careDate;

	@Column(name="CareName")
	private String careName;

	@Column(name="Price")
	private double price;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Doctor_Id")
	private AspNetUser doctor;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Patient_Id")
	private AspNetUser patient;

	public MedicalCare() {
	}

	public int getCareId() {
		return this.careId;
	}

	public void setCareId(int careId) {
		this.careId = careId;
	}

	public Date getCareDate() {
		return this.careDate;
	}

	public void setCareDate(Date careDate) {
		this.careDate = careDate;
	}

	public String getCareName() {
		return this.careName;
	}

	public void setCareName(String careName) {
		this.careName = careName;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public AspNetUser getDoctor() {
		return doctor;
	}

	public void setDoctor(AspNetUser doctor) {
		this.doctor = doctor;
	}

	public AspNetUser getPatient() {
		return patient;
	}

	public void setPatient(AspNetUser patient) {
		this.patient = patient;
	}

}