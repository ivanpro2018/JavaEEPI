package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the MedicalPathDoctors database table.
 * 
 */
@Embeddable
public class MedicalPathDoctorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MedicalPath_PathId", insertable=false, updatable=false)
	private String medicalPath_PathId;

	@Column(name="Doctor_Id", insertable=false, updatable=false)
	private String doctor_Id;

	public MedicalPathDoctorPK() {
	}
	public String getMedicalPath_PathId() {
		return this.medicalPath_PathId;
	}
	public void setMedicalPath_PathId(String medicalPath_PathId) {
		this.medicalPath_PathId = medicalPath_PathId;
	}
	public String getDoctor_Id() {
		return this.doctor_Id;
	}
	public void setDoctor_Id(String doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MedicalPathDoctorPK)) {
			return false;
		}
		MedicalPathDoctorPK castOther = (MedicalPathDoctorPK)other;
		return 
			this.medicalPath_PathId.equals(castOther.medicalPath_PathId)
			&& this.doctor_Id.equals(castOther.doctor_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.medicalPath_PathId.hashCode();
		hash = hash * prime + this.doctor_Id.hashCode();
		
		return hash;
	}
}