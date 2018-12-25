package tn.uniteam.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Employees database table.
 * 
 */
@Entity
@Table(name="Employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EmployeeId")
	private int employeeId;

	@Column(name="Address")
	private String address;

	@Column(name="EmployeeName")
	private String employeeName;

	@Column(name="HireDate")
	private Date hireDate;

	@Column(name="Job")
	private String job;

	@Column(name="Salary")
	private double salary;

	//bi-directional many-to-one association to MedicalOffice
	@ManyToOne
	@JoinColumn(name="Office_Id")
	private MedicalOffice medicalOffice;

	public Employee() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MedicalOffice getMedicalOffice() {
		return this.medicalOffice;
	}

	public void setMedicalOffice(MedicalOffice medicalOffice) {
		this.medicalOffice = medicalOffice;
	}

}