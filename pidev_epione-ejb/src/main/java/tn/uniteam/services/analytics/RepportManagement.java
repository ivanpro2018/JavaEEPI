package tn.uniteam.services.analytics;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public void sendReport() {
		// TODO Auto-generated method stub
		
	}

}
