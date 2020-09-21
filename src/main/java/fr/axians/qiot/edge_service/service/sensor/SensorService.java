package fr.axians.qiot.edge_service.service.sensor;

import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/sensors")
@RegisterRestClient
public interface SensorService {

    @GET
    @Path("/gas")
    @Produces("application/json")
    Set<Result.GasResult> getGasResult();
}
