package org.itsector.seamproject.security;

import java.util.HashMap;
import java.util.Map;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Name("authenticator")
@Scope(ScopeType.APPLICATION)
public class Authenticator {
	
	@Logger
	private Log log;
	
	@In
	private Identity identity;
	
	@In
	private Credentials credentials;
	
	private final Map<String, String> role;
	
	public Authenticator(){
		this.role = new HashMap<String, String>();
		this.role.put("aeris", "empresa");
		this.role.put("cliente", "comprador");
	}
	
	public boolean autenticar(){
		String username=credentials.getUsername();
		log.info("Autenticando #0", username);
		if("aeris".equals(username) || "cliente".equals(username)){
			identity.addRole(this.role.get(username));
			return true;
		}
		return false;
	}
	
	public boolean isEmpresa(){
		return identity.hasRole("empresa");
	}
	
	public boolean isComprador(){
		return identity.hasRole("comprador");
	}

}
