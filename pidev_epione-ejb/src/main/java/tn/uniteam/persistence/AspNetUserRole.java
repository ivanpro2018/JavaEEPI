package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AspNetUserRoles database table.
 * 
 */
@Entity
@Table(name="AspNetUserRoles")
@NamedQuery(name="AspNetUserRole.findAll", query="SELECT a FROM AspNetUserRole a")
public class AspNetUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AspNetUserRolePK idPk;
	@ManyToOne
	@JoinColumn(name="UserId", referencedColumnName="Id", insertable=false, updatable=false)
	private AspNetUser aspNetUser;
	@ManyToOne
	@JoinColumn(name="RoleId", referencedColumnName="Id", insertable=false, updatable=false)
	private AspNetRole aspNetRole;
	
	

	public AspNetUser getAspNetUser() {
		return aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public AspNetRole getAspNetRole() {
		return aspNetRole;
	}

	public void setAspNetRole(AspNetRole aspNetRole) {
		this.aspNetRole = aspNetRole;
	}

	public AspNetUserRole() {
	}

	public AspNetUserRolePK getId() {
		return this.idPk;
	}

	public void setId(AspNetUserRolePK id) {
		this.idPk = id;
	}

}