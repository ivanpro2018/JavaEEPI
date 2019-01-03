package tn.uniteam.services.doctolib;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import javax.persistence.TypedQuery;


import tn.uniteam.persistence.AspNetUser;

/**
 * Session Bean implementation class MedecinServices
 */
@Stateless
@LocalBean
public class MedecinServices implements MedecinServicesRemote, MedecinServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext//injection de depondence
	EntityManager em;//contient plusieur methode
    
    public void addUser(AspNetUser u) 
    {
		em.persist(u);
	} 
    
    public AspNetUser FindById(int id)
    {
    	
    	return em.find(AspNetUser.class, id);//User.Class type de routore
    }
    public void updateUser(AspNetUser u)
    {
    	em.merge(u);
    	
    }
    public void deleteUser(AspNetUser u)
    {
    	em.remove(u);
    }

	@Override
	public Boolean deleteUserr(String id) {
		try {
			em.remove(em.getReference(AspNetUser.class, id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
    @Override
	public  List<AspNetUser> getAllUsers() {
    	TypedQuery<AspNetUser> query  = em.createQuery("SELECT c FROM AspNetUser c ",AspNetUser.class);
		return query.getResultList();	
		
	}
    public MedecinServices() {
        // TODO Auto-generated constructor stub
    }

}
