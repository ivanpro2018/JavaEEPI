package tn.uniteam.services.espacepatient;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.uniteam.persistence.AspNetUser;

/**
 * Session Bean implementation class PatientManagement
 */
@Stateless
@LocalBean
public class PatientManagement implements PatientManagementRemote, PatientManagementLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public PatientManagement() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<AspNetUser> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addUserPhoto(String user_id, String photo) {
		AspNetUser u = (AspNetUser) em.find(AspNetUser.class, user_id);
		u.setImageName(photo);
		em.merge(u);
		System.out.println("Photo de patient ajouté avec succés ");
	}
	@Override
	public void deleteUserPhoto(String user_id) {
		AspNetUser u = (AspNetUser) em.find(AspNetUser.class, user_id);
		u.setImageName("");
		em.merge(u);
		System.out.println("Photo de patient supprimé avec succés ");
	}
	@Override
	public void addPoids(String user_id, int poids) {
		// TODO Auto-generated method stub
		AspNetUser u=em.find(AspNetUser.class, user_id);
		u.setPoids(poids);
		em.merge(u);
		System.out.println("Poids de patient ajouté avec succés ");
	}
	@Override
	public void addTaille(String user_id, int taille) {
		// TODO Auto-generated method stub
		AspNetUser u=em.find(AspNetUser.class, user_id);
		u.setTaille(taille);
		em.merge(u);
		System.out.println("Taille de patient ajouté avec succés ");
	}
	@Override
	public void addTreatment(String user, String treatment) {
		// TODO Auto-generated method stub
		AspNetUser u=em.find(AspNetUser.class, user);
		u.setTraitements(treatment);
		em.merge(u);
		System.out.println("Treatment de patient ajouté avec succés ");
	}
	@Override
	public AspNetUser getPatient(String id) {
		// TODO Auto-generated method stub
		return em.find(AspNetUser.class, id);
	}
	
	public void updatePatient(AspNetUser a)
	{
		em.merge(a);
		System.out.println("Patient  Updated");	
	}
}
