package fr.axians.qiot.edge_service.service.sensor;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/sensor")
public class SensorResource {

    @Inject
    @RestClient
    SensorService sensorService;

    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<SensorClient> type(@PathParam String type) {
        return sensorService.getByType(type);
    }

}
