package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MedicalOffices database table.
 * 
 */
@Entity
@Table(name="MedicalOffices")
@NamedQuery(name="MedicalOffice.findAll", query="SELECT m FROM MedicalOffice m")
public class MedicalOffice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OfficeId")
	private int officeId;

	@Column(name="CreationDate")
	private Date creationDate;

	@Column(name="NameOffice")
	private String nameOffice;

	//bi-directional one-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Doctor_Id")
	private AspNetUser doctor;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="medicalOffice")
	private List<Employee> employees;

	//bi-directional many-to-one association to Asset
	@OneToMany(mappedBy="medicalOffice")
	private List<Asset> assets;

	public MedicalOffice() {
	}

	public int getOfficeId() {
		return this.officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getNameOffice() {
		return this.nameOffice;
	}

	public void setNameOffice(String nameOffice) {
		this.nameOffice = nameOffice;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setMedicalOffice(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setMedicalOffice(null);

		return employee;
	}

	public List<Asset> getAssets() {
		return this.assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public Asset addAsset(Asset asset) {
		getAssets().add(asset);
		asset.setMedicalOffice(this);

		return asset;
	}

	public Asset removeAsset(Asset asset) {
		getAssets().remove(asset);
		asset.setMedicalOffice(null);

		return asset;
	}

}