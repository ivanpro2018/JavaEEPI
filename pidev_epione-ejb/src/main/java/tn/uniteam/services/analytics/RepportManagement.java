package tn.uniteam.services.analytics;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
