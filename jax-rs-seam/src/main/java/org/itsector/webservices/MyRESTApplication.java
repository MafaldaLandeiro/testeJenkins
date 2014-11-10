package org.itsector.webservices;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.core.Application;

import org.jboss.logging.Logger;
import org.jboss.seam.annotations.Name;

@Name("myRESTApplication")
public class MyRESTApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	private static final Logger log = Logger.getLogger(MyRESTApplication.class) ;

	public MyRESTApplication() {
		
		log.info("#################################");
		log.info("# START "+MyRESTApplication.class);
		log.info("#");
		log.info("# REGISTE "+HelloWorld.class);
		singletons.add(new HelloWorld());
		

		log.info("##################################");
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
