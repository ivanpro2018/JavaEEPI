package tn.uniteam.services.espacemedecin;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import tn.uniteam.persistence.Appointment;
import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Disponibility;
import tn.uniteam.persistence.Reason;

/**
 * Session Bean implementation class DoctorManagement
 */
@Stateless
@LocalBean
public class DoctorManagement implements DoctorManagementRemote, DoctorManagementLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public DoctorManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	
		public List<AspNetUser> ConsommationGetAllDoc() {
			Client client=ClientBuilder.newClient();
			WebTarget target=client.target("http://localhost:54774/APIDoctor/getDoctors");
			//WebTarget details=target.path("9d8c6214-a26a-40f3-b370-e0e1a7984e91");
			Response response=target.request().get();
			List<AspNetUser> result=response.readEntity(List.class);
			//System.out.println(result);
			response.close();
			return result;
	}

	@Override
	public void addReason(Reason r) {
		em.merge(r);
	}

	@Override
	public void updateReason(Reason r) {
		em.merge(r);
	}

	@Override
	public void deleteReason(Reason r) {
		em.remove(em.contains(r) ? r : em.merge(r));
	}

	@Override
	public List<Reason> getAllReasons() {
		String req = "select u from Reason u";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public AspNetUser getDoctorById(String id) {
		return em.find(AspNetUser.class, id);	
	}

	@Override
	public Reason getReasonById(int id) {
		return em.find(Reason.class, id);
	}

	@Override
	public void addAppointment(Appointment a) {
		em.persist(a);		
	}

	@Override
	public List<Appointment> getAllApp(String id) {
		AspNetUser d=getDoctorById(id);
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//Date date = new Date();
		//System.out.println(formatter.format(date));
		String req = "select u from Appointment u where u.aspNetUser1 =:login";
		Query query = em.createQuery(req).setParameter("login", d);
		return query.getResultList();
	}

	@Override
	public List<Date> getNbAppByWeek(String id) {
		AspNetUser d=getDoctorById(id);
		String req = "select u.date from Appointment u where u.aspNetUser1 =:login";
		Query query = em.createQuery(req).setParameter("login", d);
		return query.getResultList();
		
	}

	@Override
	public List<Date> getNbDispoByWeek(String id) {
		AspNetUser d=getDoctorById(id);
		String req = "select u.StartDate from Disponibility u where u.Doctor =:login";
		Query query = em.createQuery(req).setParameter("login", d);
		return query.getResultList();
	}

	@Override
	public List<Reason> getReasonsByDoctor(String idDoc) {
		AspNetUser d=getDoctorById(idDoc);
		String req = "select u from Reason u where u.aspNetUser =:login";
		Query query = em.createQuery(req).setParameter("login", d);
		return query.getResultList();
	}

}
