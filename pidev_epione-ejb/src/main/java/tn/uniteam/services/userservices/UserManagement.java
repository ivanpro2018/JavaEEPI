package tn.uniteam.services.userservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.uniteam.persistence.AspNetUser;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
@LocalBean
public class UserManagement implements UserManagementRemote, UserManagementLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public UserManagement() {
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public List<AspNetUser> getAllUsers() {
		// TODO Auto-generated method stub
		String req = "select u from AspNetUser u";
		Query query = em.createQuery(req);
		return query.getResultList();
	}


	@Override
	public void addUser(AspNetUser a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}


	@Override
	public void updateUser(AspNetUser a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}


	@Override
	public void deleteUser(AspNetUser a) {
		// TODO Auto-generated method stub
		em.remove(em.contains(a) ? a : em.merge(a));
	}


	@Override
	public AspNetUser loginUser(String username) {
		// TODO Auto-generated method stub
		String req = "select u from AspNetUser u where u.username =:login";
		Query query = em.createQuery(req).setParameter("login", username);//.setParameter("password", password);
		return (AspNetUser) query.getSingleResult();
	}


	@Override
	public AspNetUser searchUser(String Id) {
		// TODO Auto-generated method stub
		return em.find(AspNetUser.class, Id);
	}
    

}
