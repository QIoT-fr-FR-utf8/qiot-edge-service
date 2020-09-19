package fr.axians.qiot.edge_service.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.Set;

import fr.axians.qiot.edge_service.rest.client.Station;
import fr.axians.qiot.edge_service.service.RegistrationService;

@Path("/register")
public class Registration {

    @Inject
    @RestClient
    RegistrationService regService;

    @GET
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    public Set<Station> register() {
                return regService.getByRegister(serial, name, longitude, latitude);
    }
}