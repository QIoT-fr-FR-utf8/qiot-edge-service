package fr.axians.qiot.edge_service.service;

import javax.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.core.MediaType;
import fr.axians.qiot.edge_service.rest.client.*;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient
public interface RegistrationService {

    @PUT
    @Path("/serial/{serial}/name/{name}/longitude/{longitude}/latitude/{latitude}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    Set<station>  getByRegister(@PathParam("serial") String serial,
    @PathParam("name") String name,
    @PathParam("longitude") double longitude,
    @PathParam("latitude") double latitude);
}