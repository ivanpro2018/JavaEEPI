package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;

import tn.uniteam.persistence.AspNetUser;


/**
 * The persistent class for the Reasons database table.
 * 
 */
@Entity
@Table(name="Reasons")
@NamedQuery(name="Reason.findAll", query="SELECT r FROM Reason r")
public class Reason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReasonId")
	private int reasonId;

	@Column(name="Prix")
	private float prix;

	@Column(name="ReasonContent")
	private String reasonContent;
	
	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Doctor_Id")	
	private AspNetUser aspNetUser;

	public Reason() {
	}
	

	public Reason(float prix, String reasonContent) {
		super();
		this.prix = prix;
		this.reasonContent = reasonContent;
	}
	
	
	

	public Reason(int reasonId, float prix, String reasonContent, AspNetUser aspNetUser) {
		super();
		this.reasonId = reasonId;
		this.prix = prix;
		this.reasonContent = reasonContent;
		this.aspNetUser = aspNetUser;
	}


	public Reason(float prix, String reasonContent, AspNetUser aspNetUser) {
		super();
		this.prix = prix;
		this.reasonContent = reasonContent;
		this.aspNetUser = aspNetUser;
	}


	public Reason(int reasonId, float prix, String reasonContent) {
		super();
		this.reasonId = reasonId;
		this.prix = prix;
		this.reasonContent = reasonContent;
	}


	public int getReasonId() {
		return this.reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getReasonContent() {
		return this.reasonContent;
	}

	public void setReasonContent(String reasonContent) {
		this.reasonContent = reasonContent;
	}

	public AspNetUser getAspNetUser() {
		return aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}


	@Override
	public String toString() {
		return "Reason [reasonId=" + reasonId + ", prix=" + prix + ", reasonContent=" + reasonContent + ", aspNetUser="
				+ aspNetUser + "]";
	}

}