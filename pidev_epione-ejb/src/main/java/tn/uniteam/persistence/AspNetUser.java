package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
@Table(name="AspNetUsers")
@NamedQuery(name="AspNetUser.findAll", query="SELECT a FROM AspNetUser a")
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public enum Gender {
		male,female
	}
	
	public enum Speciality {
        Cardiologist,
        Dentist,
        Dermatologist,
        Gastroenterologist,
        Generalist,
        Gynecologist,
        Neurologist,
        Ophthalmologist,
        Pediatrician,
        Therapist
	}
	

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	@Column(name="Address")
	private String address;

	@Column(name="Age")
	private int age;

	@Column(name="BirthDate")
	private Date birthDate;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="Gender")
	private Gender gender;

	@Column(name="ImageName")
	private String imageName;

	@Column(name="LastName")
	private String lastName;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Timestamp lockoutEndDateUtc;

	@Column(name="PasswordHash")
	private String passwordHash;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name="Poids")
	private int poids;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="Speciality")
	private Speciality speciality;

	@Column(name="Taille")
	private int taille;

	@Column(name="Traitements")
	private String traitements;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name="UserName")
	private String username;
	
	public AspNetUser() {
	}

	public AspNetUser(String id, int accessFailedCount, String discriminator, boolean emailConfirmed,
			boolean lockoutEnabled, boolean phoneNumberConfirmed, boolean twoFactorEnabled, String userName) {
		super();
		this.id = id;
		this.accessFailedCount = accessFailedCount;
		this.discriminator = discriminator;
		this.emailConfirmed = emailConfirmed;
		this.lockoutEnabled = lockoutEnabled;
		this.phoneNumberConfirmed = phoneNumberConfirmed;
		this.twoFactorEnabled = twoFactorEnabled;
		this.username = userName;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public int getPoids() {
		return this.poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getTraitements() {
		return this.traitements;
	}

	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}


	@Override
	public String toString() {
		return "User : [id=" + id + ", accessFailedCount=" + accessFailedCount + ", address=" + address + ", age="
				+ age + ", birthDate=" + birthDate + ", discriminator=" + discriminator + ", email=" + email
				+ ", emailConfirmed=" + emailConfirmed + ", firstName=" + firstName + ", gender=" + gender
				+ ", imageName=" + imageName + ", lastName=" + lastName + ", lockoutEnabled=" + lockoutEnabled
				+ ", lockoutEndDateUtc=" + lockoutEndDateUtc + ", passwordHash=" + passwordHash + ", phoneNumber="
				+ phoneNumber + ", phoneNumberConfirmed=" + phoneNumberConfirmed + ", poids=" + poids
				+ ", securityStamp=" + securityStamp + ", speciality=" + speciality + ", taille=" + taille
				+ ", traitements=" + traitements + ", twoFactorEnabled=" + twoFactorEnabled + ", userName=" + username
				+ "]";
	}

}