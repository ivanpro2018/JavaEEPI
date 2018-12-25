package tn.uniteam.services.userservices;

import java.util.List;

import javax.ejb.Local;

import tn.uniteam.persistence.AspNetUser;

@Local
public interface UserManagementLocal {
	public List<AspNetUser> getAllUsers();
}
