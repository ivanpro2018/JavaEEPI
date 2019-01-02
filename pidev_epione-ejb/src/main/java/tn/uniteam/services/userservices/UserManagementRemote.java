package tn.uniteam.services.userservices;

import java.util.List;

import javax.ejb.Remote;

import tn.uniteam.persistence.AspNetUser;

@Remote
public interface UserManagementRemote {
		public List<AspNetUser> getAllUsers();
		public List<AspNetUser> getAllDoctors();
		public List<AspNetUser> getAllPatients();
		public List<AspNetUser> getOthersDoctors(AspNetUser doc);
		public void addUser(AspNetUser a);
		public void updateUser(AspNetUser a);
		public void deleteUser(AspNetUser a);
<<<<<<< HEAD
		public AspNetUser loginUser(String username, String password);
		public AspNetUser searchUser(String id);
=======
		public String loginUser(AspNetUser user);
		public AspNetUser loginUser(String username);
		public AspNetUser searchUser(String username);
>>>>>>> b6cbff28586b366b410cb5a6202c0eb000e0cb33
	}

