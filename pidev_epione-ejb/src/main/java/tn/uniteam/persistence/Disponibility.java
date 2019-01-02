package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Disponibilities database table.
 * 
 */
@Entity
@Table(name="Disponibilities")
@NamedQuery(name="Disponibility.findAll", query="SELECT d FROM Disponibility d")
public class Disponibility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;

	@Column(name="Description")
	private String Description;

	@Column(name="EndDate")
	private Timestamp EndDate;

	@Column(name="StartDate")
	private Timestamp StartDate;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="DoctorId")
	private AspNetUser Doctor;

	public Disponibility() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Timestamp getEndDate() {
		return EndDate;
	}

	public void setEndDate(Timestamp dndDate) {
		EndDate = dndDate;
	}

	public Timestamp getStartDate() {
		return StartDate;
	}

	public void setStartDate(Timestamp startDate) {
		StartDate = startDate;
	}

	public AspNetUser getDoctor() {
		return Doctor;
	}

	public void setDoctor(AspNetUser doctor) {
		Doctor = doctor;
	}

	public Disponibility(int id, String description, Timestamp dndDate, Timestamp startDate, AspNetUser doctor) {
		super();
		Id = id;
		Description = description;
		EndDate = dndDate;
		StartDate = startDate;
		Doctor = doctor;
	}

	public Disponibility(String description, Timestamp dndDate, Timestamp startDate, AspNetUser doctor) {
		super();
		Description = description;
		EndDate = dndDate;
		StartDate = startDate;
		Doctor = doctor;
	}

	@Override
	public String toString() {
		return "Disponibility [Id=" + Id + ", Description=" + Description + ", DndDate=" + EndDate + ", StartDate="
				+ StartDate + ", Doctor=" + Doctor + "]";
	}

	

}