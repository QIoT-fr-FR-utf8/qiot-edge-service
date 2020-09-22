package fr.axians.qiot.edge_service.service.sensor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/sensor")
public class SensorResource {

    @Inject
    @RestClient
    SensorService sensorService;

    @GET
    @Path("/gas")
    @Produces(MediaType.APPLICATION_JSON)
    public Result toto() {
        
        return sensorService.getResult();
    }

}
