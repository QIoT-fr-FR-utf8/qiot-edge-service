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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.Set;

import fr.axians.qiot.edge_service.rest.client.Station;
import fr.axians.qiot.edge_service.service.RegistrationService;

@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@Path("/register")
public class Registration {

    public String serial = "36c2a3079e97428fa514f2beb0fd4e6a";
    public String name = "FRutf8";
    public double longitude = 2.3;
    public double latitude = 48.8;

    @Inject
    @RestClient
    RegistrationService regService;

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Set<Station> register(@PathParam("serial") String serial,
            @PathParam("name") String name,
            @PathParam("longitude") double longitude,
            @PathParam("latitude") double latitude) {

            return regService.getByStations("36c2a3079e97428fa514f2beb0fd4e6a", "FRutf8", 2.3, 48.8);
    }
}