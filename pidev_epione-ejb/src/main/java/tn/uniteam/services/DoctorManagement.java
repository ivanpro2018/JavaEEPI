package tn.uniteam.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class DoctorManagement
 */
@Stateless
@LocalBean
public class DoctorManagement implements DoctorManagementRemote, DoctorManagementLocal {

    /**
     * Default constructor. 
     */
    public DoctorManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void Consommation() {
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target("http://localhost:54774/APIDoctor/getDoctors");
		//WebTarget details=target.path("9d8c6214-a26a-40f3-b370-e0e1a7984e91");
		Response response=target.request().get();
		String result=response.readEntity(String.class);
		System.out.println(result);
		response.close();
	}

}
