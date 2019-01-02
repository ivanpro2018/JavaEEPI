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
	private String Id;

	@Column(name="AccessFailedCount")
	private int AccessFailedCount;

	@Column(name="Address")
	private String Address;

	@Column(name="Age")
	private int Age;

	@Column(name="BirthDate")
	private Date BirthDate;

	@Column(name="Discriminator")
	private String Discriminator;

	@Column(name="Email")
	private String Email;

	@Column(name="EmailConfirmed")
	private boolean EmailConfirmed;

	@Column(name="FirstName")
	private String FirstName;

	@Column(name="Gender")
	private Gender Gender;

	@Column(name="ImageName")
	private String ImageName;

	@Column(name="LastName")
	private String LastName;

	@Column(name="LockoutEnabled")
	private boolean LockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Timestamp LockoutEndDateUtc;

	@Column(name="PasswordHash")
	private String PasswordHash;

	@Column(name="PhoneNumber")
	private String PhoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean PhoneNumberConfirmed;

	@Column(name="Poids")
	private int Poids;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="Speciality")
	private Speciality Speciality;

	@Column(name="Taille")
	private int Taille;

	@Column(name="Traitements")
	private String Traitements;

	@Column(name="TwoFactorEnabled")
	private boolean TwoFactorEnabled;

	@Column(name="UserName")
	private String UserName;
	
	public AspNetUser() {
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public int getAccessFailedCount() {
		return AccessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		AccessFailedCount = accessFailedCount;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	
	public String getDiscriminator() {
		return Discriminator;
	}

	public void setDiscriminator(String discriminator) {
		Discriminator = discriminator;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isEmailConfirmed() {
		return EmailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		EmailConfirmed = emailConfirmed;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public Gender getGender() {
		return Gender;
	}

	public void setGender(Gender gender) {
		Gender = gender;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public boolean isLockoutEnabled() {
		return LockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		LockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return LockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		LockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return PasswordHash;
	}

	public void setPasswordHash(String passwordHash) {
		PasswordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public boolean isPhoneNumberConfirmed() {
		return PhoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		PhoneNumberConfirmed = phoneNumberConfirmed;
	}

	public int getPoids() {
		return Poids;
	}

	public void setPoids(int poids) {
		Poids = poids;
	}

	public String getSecurityStamp() {
		return securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public Speciality getSpeciality() {
		return Speciality;
	}

	public void setSpeciality(Speciality speciality) {
		Speciality = speciality;
	}

	public int getTaille() {
		return Taille;
	}

	public void setTaille(int taille) {
		Taille = taille;
	}

	public String getTraitements() {
		return Traitements;
	}

	public void setTraitements(String traitements) {
		Traitements = traitements;
	}

	public boolean isTwoFactorEnabled() {
		return TwoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		TwoFactorEnabled = twoFactorEnabled;
	}

	



	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	

	

	@Override
	public String toString() {
		return "AspNetUser [Id=" + Id + ", AccessFailedCount=" + AccessFailedCount + ", Address=" + Address + ", Age="
				+ Age + ", BirthDate=" + BirthDate + ", Discriminator=" + Discriminator + ", Email=" + Email
				+ ", EmailConfirmed=" + EmailConfirmed + ", FirstName=" + FirstName + ", Gender=" + Gender
				+ ", ImageName=" + ImageName + ", LastName=" + LastName + ", LockoutEnabled=" + LockoutEnabled
				+ ", LockoutEndDateUtc=" + LockoutEndDateUtc + ", PasswordHash=" + PasswordHash + ", PhoneNumber="
				+ PhoneNumber + ", PhoneNumberConfirmed=" + PhoneNumberConfirmed + ", Poids=" + Poids
				+ ", securityStamp=" + securityStamp + ", Speciality=" + Speciality + ", Taille=" + Taille
				+ ", Traitements=" + Traitements + ", TwoFactorEnabled=" + TwoFactorEnabled + ", UserName=" + UserName
				+ "]";
	}

	public AspNetUser(String id, int accessFailedCount, String address, int age, Date birthDate, String discriminator,
			String email, boolean emailConfirmed, String firstName, tn.uniteam.persistence.AspNetUser.Gender gender,
			String imageName, String lastName, boolean lockoutEnabled, Timestamp lockoutEndDateUtc, String passwordHash,
			String phoneNumber, boolean phoneNumberConfirmed, int poids, String securityStamp,
			tn.uniteam.persistence.AspNetUser.Speciality speciality, int taille, String traitements,
			boolean twoFactorEnabled, String userName) {
		super();
		Id = id;
		AccessFailedCount = accessFailedCount;
		Address = address;
		Age = age;
		BirthDate = birthDate;
		Discriminator = discriminator;
		Email = email;
		EmailConfirmed = emailConfirmed;
		FirstName = firstName;
		Gender = gender;
		ImageName = imageName;
		LastName = lastName;
		LockoutEnabled = lockoutEnabled;
		LockoutEndDateUtc = lockoutEndDateUtc;
		PasswordHash = passwordHash;
		PhoneNumber = phoneNumber;
		PhoneNumberConfirmed = phoneNumberConfirmed;
		Poids = poids;
		this.securityStamp = securityStamp;
		Speciality = speciality;
		Taille = taille;
		Traitements = traitements;
		TwoFactorEnabled = twoFactorEnabled;
		UserName = userName;
	}

	public AspNetUser(String id, int accessFailedCount, String address, int age, String discriminator,
			String email, boolean emailConfirmed, String firstName, tn.uniteam.persistence.AspNetUser.Gender gender,
			String imageName, String lastName, boolean lockoutEnabled, Timestamp lockoutEndDateUtc, String passwordHash,
			String phoneNumber, boolean phoneNumberConfirmed, int poids, String securityStamp,
			tn.uniteam.persistence.AspNetUser.Speciality speciality, int taille, String traitements,
			boolean twoFactorEnabled, String username) {
		super();
		Id = id;
		AccessFailedCount = accessFailedCount;
		Address = address;
		Age = age;
		Discriminator = discriminator;
		Email = email;
		EmailConfirmed = emailConfirmed;
		FirstName = firstName;
		Gender = gender;
		ImageName = imageName;
		LastName = lastName;
		LockoutEnabled = lockoutEnabled;
		LockoutEndDateUtc = lockoutEndDateUtc;
		PasswordHash = passwordHash;
		PhoneNumber = phoneNumber;
		PhoneNumberConfirmed = phoneNumberConfirmed;
		Poids = poids;
		this.securityStamp = securityStamp;
		Speciality = speciality;
		Taille = taille;
		Traitements = traitements;
		TwoFactorEnabled = twoFactorEnabled;
		UserName = username;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}

	public AspNetUser(String address, int age, String discriminator, String email, String firstName,
			tn.uniteam.persistence.AspNetUser.Gender gender, String imageName, String lastName, String passwordHash,
			String phoneNumber, boolean phoneNumberConfirmed, int poids,
			tn.uniteam.persistence.AspNetUser.Speciality speciality, int taille, String traitements, String username) {
		super();
		Address = address;
		Age = age;
		Discriminator = discriminator;
		Email = email;
		FirstName = firstName;
		Gender = gender;
		ImageName = imageName;
		LastName = lastName;
		PasswordHash = passwordHash;
		PhoneNumber = phoneNumber;
		PhoneNumberConfirmed = phoneNumberConfirmed;
		Poids = poids;
		Speciality = speciality;
		Taille = taille;
		Traitements = traitements;
		UserName = username;
	}
	

}