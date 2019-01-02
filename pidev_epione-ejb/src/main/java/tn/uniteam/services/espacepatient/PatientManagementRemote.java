package tn.uniteam.services.espacepatient;



import java.util.List;

import javax.ejb.Remote;

import tn.uniteam.persistence.AspNetUser;

@Remote
public interface PatientManagementRemote {
	public List<AspNetUser> getAllPatients();
	public void addUserPhoto(String user_id, String photo);
	public void addPoids(String user_id,int poids);
	public void addTaille(String user_id,int taille);
	public void addTreatment(String user,String treatment);
	public AspNetUser getPatient(String id);
	public void updatePatient(AspNetUser a);
	void deleteUserPhoto(String user_id);
}
