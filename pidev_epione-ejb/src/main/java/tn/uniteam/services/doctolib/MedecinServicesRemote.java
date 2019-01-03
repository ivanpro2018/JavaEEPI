package tn.uniteam.services.doctolib;

import java.util.List;

import javax.ejb.Remote;

import tn.uniteam.persistence.AspNetUser;

@Remote
public interface MedecinServicesRemote {
	public void addUser(AspNetUser u) ;
	   public AspNetUser FindById(int id);
	   public void updateUser(AspNetUser u);
	   public void deleteUser(AspNetUser u);
	  public List<AspNetUser> getAllUsers();
	  public Boolean deleteUserr(String id); 
}
