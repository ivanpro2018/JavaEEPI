package tn.uniteam.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AspNetUserRolePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String RoleId;
	private String UserId;
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RoleId == null) ? 0 : RoleId.hashCode());
		result = prime * result + ((UserId == null) ? 0 : UserId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AspNetUserRolePK other = (AspNetUserRolePK) obj;
		if (RoleId == null) {
			if (other.RoleId != null)
				return false;
		} else if (!RoleId.equals(other.RoleId))
			return false;
		if (UserId == null) {
			if (other.UserId != null)
				return false;
		} else if (!UserId.equals(other.UserId))
			return false;
		return true;
	}
	
	
}
