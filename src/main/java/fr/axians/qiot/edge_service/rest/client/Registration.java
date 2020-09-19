package fr.axians.qiot.edge_service.rest.client;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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

    @GET
    public int register(@PathParam("serial") String serial,
            @PathParam("name") String name,
            @PathParam("longitude") double longitude,
            @PathParam("latitude") double latitude) {

            Station st = new Station();
            st.serial = "36c2a3079e97428fa514f2beb0fd4e6a";
            st.name = "FRutf8";
            st.longitude = 2.3;
            st.latitude = 48.8;

            st.id = regService.regStation(st.serial, st.name, st.longitude, st.latitude);

            return st.id;
    }
}