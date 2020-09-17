package fr.axians.qiot.edge_service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/register")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class Registration {

@Inject
RegistrationService regService;

String serial = "36c2a3079e97428fa514f2beb0fd4e6a";
String name = "FRutf8";
double longitude = "2.3";
double latitude = "48.8";

    @PUT
    @Path("/serial/{serial}/name/{name}/longitude/{longitude}/latitude/{latitude}")
    public int register(@PathParam("serial") String serial,
            @PathParam("name") String name,
            @PathParam("longitude") double longitude,
            @PathParam("latitude") double latitude) {

        int returnint = regService.register(serial, name, longitude, latitude);
        return returnint;
    }
}