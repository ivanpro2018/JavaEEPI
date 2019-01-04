package tn.uniteam.services.analytics;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import tn.uniteam.persistence.Appointment;
import tn.uniteam.persistence.AspNetUser;

/**
 * Session Bean implementation class ConsommationStatistiquesManagement
 */
@Stateless
@LocalBean
public class ConsommationStatistiquesManagement implements ConsommationStatistiquesManagementRemote, ConsommationStatistiquesManagementLocal {

    /**
     * Default constructor. 
     */
    public ConsommationStatistiquesManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<AspNetUser> ConsommationGetTreatedPatientsOfDoctor(String id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:54774/analytics/docteurDetails/" + id);
		Response response = target.request().get();
		List<AspNetUser> result = response.readEntity(List.class);
		response.close();
		return result;
	}

	@Override
	public List<AspNetUser> ConsommationGetNotTreatedPatientsOfDoctor(String id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:54774/analytics/docteurDetailsNT/" + id);
		Response response = target.request().get();
		List<AspNetUser> result = response.readEntity(List.class);
		response.close();
		return result;
	}

	@Override
	public List<Appointment> ConsommationGetAppointmentsOfDoctor(String id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:54774/analytics/docteurAPP/" + id);
		Response response = target.request().get();
		List<Appointment> result = response.readEntity(List.class);
		response.close();
		return result;
	}

}
