package tn.uniteam.webservices.users;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("Hi")
public class HelloUser {
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@FormParam("username") String username, @FormParam("password") String password) {
		return "Hello guy ! "+username+" "+password;
	}
}
