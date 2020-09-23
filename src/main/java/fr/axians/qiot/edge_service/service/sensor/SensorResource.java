package fr.axians.qiot.edge_service.service.sensor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import fr.axians.qiot.edge_service.rest.client.registration.AppLifecycleBean;
import com.fasterxml.jackson.databind.JsonNode;

@Path("/sensor")
public class SensorResource {

    @Inject
    @RestClient
    SensorService sensorService;

    @Inject
    public AppLifecycleBean app;

    @GET
    @Path("/gas")
    @Produces(MediaType.APPLICATION_JSON)
    public GasResult getGas() {
        Result res = sensorService.getGasResult();
        GasResult sensor = new GasResult(app.getRegistrationId(), (res.result.get("instant")).toString(), (Double) res.result.get("nh3") , ( Double ) res.result.get("oxidising"), (Double)res.result.get("reducing") );
        return sensor;
    }

    @GET
    @Path("/pollution")
    @Produces(MediaType.APPLICATION_JSON)
    public PollutionResult getPollution() {
        Result res = sensorService.getPollutionResult();
        PollutionResult sensor = new PollutionResult( app.getRegistrationId(), (Integer)res.result.get("PM10") , (Integer)res.result.get("PM10_atm") , (Integer)res.result.get("PM1_0") ,(Integer)res.result.get("PM1_0_atm") ,(Integer)res.result.get("PM2_5") ,(Integer)res.result.get("PM2_5_atm") ,(Integer) res.result.get("gt0_3um") ,(Integer) res.result.get("gt0_5_um") ,(Integer) res.result.get("gt10um") ,(Integer)res.result.get("gt1_0um") ,(Integer)res.result.get("gt2_5um") ,(Integer) res.result.get("gt5_0um") , res.result.get("instant").toString());
        return sensor;
    }
}
