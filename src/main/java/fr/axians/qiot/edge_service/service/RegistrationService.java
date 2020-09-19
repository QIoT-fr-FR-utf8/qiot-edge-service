package fr.axians.qiot.edge_service.service;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@Path("/v1")
@RegisterRestClient
public interface RegistrationService {

    @PUT
    @Path("/register/serial/{serial}/name/{name}/longitude/{longitude}/latitude/{latitude}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public int regStation(@PathParam("serial") String serial,
    @PathParam("name") String name,
    @PathParam("longitude") double longitude,
    @PathParam("latitude") double latitude);

    @DELETE
    @Path("/id/{id}")
    public void unregStation(@PathParam("id") int id);

}