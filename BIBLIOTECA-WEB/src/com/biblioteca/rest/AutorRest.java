package com.biblioteca.rest;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.biblioteca.entidad.Autor;
import com.biblioteca.session.AutorSession;

@Path("/autor")
public class AutorRest {
	
	@EJB
	AutorSession as;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public java.util.Map<String, Object> consultar() {
		return as.consultarAutores();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	public java.util.Map<String, Object> consultarPorNombre(@QueryParam("nombre") String nombre) {
		return as.consultarAutoresPorNombre(nombre);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	//BodyParam
	public Autor incluir(Autor autor) {
		return as.incluir(autor);
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	//BodyParam
	public Autor editar(Autor autor) {
		return as.actualizar(autor); 
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eliminar/{id}")
	//PathParam
	public void eliminar(@PathParam("id") Integer codigo) {
		as.eliminar(codigo);
	}

}
