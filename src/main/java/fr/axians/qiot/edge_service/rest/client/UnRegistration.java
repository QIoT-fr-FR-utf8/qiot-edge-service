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
import fr.axians.qiot.edge_service.rest.client.Station;


@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@Path("/unregister")
public class UnRegistration {

    @Inject
    @RestClient
    RegistrationService regService;
    @GET
    public int unregister(@PathParam("id") int id){
        return 0;
    }

}
