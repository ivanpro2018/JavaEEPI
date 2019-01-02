package tn.uniteam.services.espacepatient;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import tn.uniteam.persistence.Appointment;


/**
 * Session Bean implementation class AppointmentManagement
 */
@Stateless
@LocalBean
public class AppointmentManagement implements AppointmentManagementRemote, AppointmentManagementLocal {

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AppointmentManagement() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<Appointment> ConsommationAppointmentsList() {
		// TODO Auto-generated method stub
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:54774/API/AppointmentsList");
		//WebTarget details=target.path("9d8c6214-a26a-40f3-b370-e0e1a7984e91");
		Response response=target.request().get();
		@SuppressWarnings("unchecked")
		List<Appointment> result= response.readEntity(List.class);
				
				//response.readEntity(List.class);
		//System.out.println(result);
		response.close();
		return result;
	}
    

}
