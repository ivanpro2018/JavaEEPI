package tn.uniteam.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the MedicalPaths database table.
 * 
 */
@Entity
@Table(name="MedicalPaths")
@NamedQuery(name="MedicalPath.findAll", query="SELECT m FROM MedicalPath m")
public class MedicalPath implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PathId")
	private String pathId;

	@Column(name="Description")
	private String Description;

	@Column(name="Justification")
	private String justification;

	@Column(name="RecommandationDate")
	private Date RecommendationDate;

	@Column(name="RecommendedSpeciality")
	private String recommendedSpeciality;

	@Column(name="ValidatedSteps")
	private boolean validatedSteps;

	//bi-directional one-to-one association to AspNetUser
	@OneToOne
	@JoinColumn(name="Patient_id")
	private AspNetUser aspNetUser;

	public MedicalPath() {
	}

	public String getPathId() {
		return this.pathId;
	}

	public void setPathId(String pathId) {
		this.pathId = pathId;
	}

	public String getJustification() {
		return this.justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getRecommendedSpeciality() {
		return this.recommendedSpeciality;
	}

	public void setRecommendedSpeciality(String recommendedSpeciality) {
		this.recommendedSpeciality = recommendedSpeciality;
	}

	public boolean getValidatedSteps() {
		return this.validatedSteps;
	}

	public void setValidatedSteps(boolean validatedSteps) {
		this.validatedSteps = validatedSteps;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getRecommendationDate() {
		return RecommendationDate;
	}

	public void setRecommendationDate(Date recommendationDate) {
		RecommendationDate = recommendationDate;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}