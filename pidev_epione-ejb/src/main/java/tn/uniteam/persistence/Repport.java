package tn.uniteam.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Repports database table.
 * 
 */
@Entity
@Table(name="Repports")
@NamedQuery(name="Repport.findAll", query="SELECT r FROM Repport r")
public class Repport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RepportId")
	private int repportId;

	@Column(name="RepportName")
	private String repportName;

	@Column(name="RepportDate")
	private Date repportDate;

	@Column(name="PatientName")
	private String patientName;

	@Column(name="DiseaseDeclared")
	private String diseaseDeclared;

	@Column(name="Symptoms")
	private String symptoms;

	@Column(name="Abnormalities")
	private String abnormalities;

	@Column(name="ImageDisease")
	private String imageDisease;

	@Column(name="RepportContent")
	private String repportContent;

	@Column(name="Diagnostic")
	private String diagnostic;

	@Column(name="ReferentDoctor")
	private String referentDoctor;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	private AspNetUser aspNetUser;

	public Repport() {
	}

	public int getRepportId() {
		return this.repportId;
	}

//	public void setRepportId(int repportId) {
//		this.repportId = repportId;
//	}

	public String getRepportName() {
		return this.repportName;
	}

	public void setRepportName(String repportName) {
		this.repportName = repportName;
	}

	public Date getRepportDate() {
		return repportDate;
	}

	public void setRepportDate(Date repportDate) {
		this.repportDate = repportDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDiseaseDeclared() {
		return diseaseDeclared;
	}

	public void setDiseaseDeclared(String diseaseDeclared) {
		this.diseaseDeclared = diseaseDeclared;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getAbnormalities() {
		return abnormalities;
	}

	public void setAbnormalities(String abnormalities) {
		this.abnormalities = abnormalities;
	}

	public String getImageDisease() {
		return imageDisease;
	}

	public void setImageDisease(String imageDisease) {
		this.imageDisease = imageDisease;
	}

	public String getRepportContent() {
		return repportContent;
	}

	public void setRepportContent(String repportContent) {
		this.repportContent = repportContent;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getReferentDoctor() {
		return referentDoctor;
	}

	public void setReferentDoctor(String referentDoctor) {
		this.referentDoctor = referentDoctor;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}