package tn.uniteam.services.userservices;

import java.util.List;

import javax.ejb.Remote;

import tn.uniteam.persistence.AspNetUser;

@Remote
public interface UserManagementRemote {
		public List<AspNetUser> getAllUsers();
		public void addUser(AspNetUser a);
		public void updateUser(AspNetUser a);
		public void deleteUser(AspNetUser a);
		public AspNetUser loginUser(String username);
		public AspNetUser searchUser(String username);
	}

