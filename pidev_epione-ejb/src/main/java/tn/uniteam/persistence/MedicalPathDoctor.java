package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MedicalPathDoctors database table.
 * 
 */
@Entity
@Table(name="MedicalPathDoctors")
@NamedQuery(name="MedicalPathDoctor.findAll", query="SELECT m FROM MedicalPathDoctor m")
public class MedicalPathDoctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MedicalPathDoctorPK id;

	public MedicalPathDoctor() {
	}

	public MedicalPathDoctorPK getId() {
		return this.id;
	}

	public void setId(MedicalPathDoctorPK id) {
		this.id = id;
	}

}