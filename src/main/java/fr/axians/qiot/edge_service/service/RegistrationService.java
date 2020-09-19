package fr.axians.qiot.edge_service.service;

import javax.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
public class station {
    public Int id;
    public String serial = "36c2a3079e97428fa514f2beb0fd4e6a";
    public String name = "FRutf8";
    public double longitude = 2.3;
    public double latitude = 48.8;
}


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