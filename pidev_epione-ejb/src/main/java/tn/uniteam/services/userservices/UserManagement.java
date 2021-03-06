package tn.uniteam.services.userservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		String req = "select u from AspNetUser u where u.UserName =:login or u.Email =:email";
		Query query = em.createQuery(req).setParameter("login", username).setParameter("email", username);
		return (AspNetUser) query.getSingleResult();
	}


	@Override
	public AspNetUser searchUser(String id) {
		// TODO Auto-generated method stub
		return em.find(AspNetUser.class, id);
	}


	@Override
	public List<AspNetUser> getAllDoctors() {
		// TODO Auto-generated method stub
		String req = "select u from AspNetUser u where u.Discriminator = 'Doctor'";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<AspNetUser> getOthersDoctors(AspNetUser doc) {
		// TODO Auto-generated method stub
		String req = "select u from AspNetUser u where u.Discriminator = 'Doctor' and u.Id <>:ids";
		Query query = em.createQuery(req).setParameter("ids", doc.getId());
		return query.getResultList();
	}

	@Override
	public List<AspNetUser> getAllPatients() {
		String req = "select u from AspNetUser u where u.Discriminator = 'Patient'";
		Query query = em.createQuery(req);
		return query.getResultList();
	}


	@Override
	public String loginUser(AspNetUser user) {
		// TODO Auto-generated method stub
//		String req = "select u from AspNetUser u where u.username =:login and u.passwordHash =:password";
//		Query query = em.createQuery(req).setParameter("login", username).setParameter("password", password);
//		return (AspNetUser) query.getSingleResult();
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:54774/api/Login");

		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		String result = reponse.readEntity(String.class);
		System.out.println(result);
		if (result.equals("")) {
			 
			reponse.close();
			return result;
		} 
		else {
			 
			reponse.close();
			return result;
		}

	}


}
