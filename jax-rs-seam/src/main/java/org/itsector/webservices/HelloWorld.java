package org.itsector.webservices;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.itsector.entities.Person;

@Path("/HelloWorld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld {

	@GET()
	public Person sayHello() {
	    
		Person person = new Person();
		person.setAge(24);
		person.setName("Nuno Bento");
		
		return person;
	}
	
	@POST
	public void setProfessional(){
		
		
		
	}
	
	
}
