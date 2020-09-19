package fr.axians.qiot.edge_service.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.Set;

import fr.axians.qiot.edge_service.service.RegistrationService;

@Path("/register")
public class Registration {

@Inject
@RestClient
RegistrationService regService;

    @PUT
    @Path("/serial/{serial}/name/{name}/longitude/{longitude}/latitude/{latitude}")
    @Produces(MediaType.TEXT_PLAIN)
    public Set<Station> register(@PathParam("serial") String serial,
            @PathParam("name") String name,
            @PathParam("longitude") double longitude,
            @PathParam("latitude") double latitude) {
                return regService.getByRegister(serial, name, longitude, latitude);
    }
}