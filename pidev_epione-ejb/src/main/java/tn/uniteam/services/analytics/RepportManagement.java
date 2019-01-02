package tn.uniteam.services.analytics;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Repport;

/**
 * Session Bean implementation class RepportManagement
 */
@Stateless
@LocalBean
public class RepportManagement implements RepportManagementRemote, RepportManagementLocal {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public RepportManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void sendReport(Repport r) {
		// TODO Auto-generated method stub
		r.setRepportDate(new Date());
		em.persist(r);
	}

	@Override
	public List<Repport> getAllSentReports(AspNetUser doctor) {
		// TODO Auto-generated method stub
		String req = "select r from Repport r where r.aspNetUser =:id";
		Query query = em.createQuery(req).setParameter("id", doctor);
		return query.getResultList();
	}

	@Override
	public List<Repport> getAllReceivedReports(AspNetUser doctor) {
		// TODO Auto-generated method stub
		String req = "select r from Repport r, AspNetUser a "
				+ "where a.id =:id and r.referentDoctor =:name";
		Query query = em.createQuery(req).setParameter("id", doctor.getId()).setParameter("name", doctor.getFirstName() + " " + doctor.getLastName());
		return query.getResultList();
	}

}
