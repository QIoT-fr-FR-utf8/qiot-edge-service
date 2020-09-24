package fr.axians.qiot.edge_service.service.telemetry;



import fr.axians.qiot.edge_service.service.sensor.Result;
import fr.axians.qiot.edge_service.service.sensor.GasResult;
import fr.axians.qiot.edge_service.service.sensor.SensorResource;
import fr.axians.qiot.edge_service.service.sensor.PollutionResult;

import javax.inject.Inject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.eclipse.microprofile.rest.client.inject.RestClient;



import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

public class TelemetryService {
    
    @Inject
    SensorResource sr;

    
    /* Gas stream */
    @Outgoing("gas-stream")
    public Flowable <String> streamGasData() throws JsonProcessingException {
        
        /* Creating the ObjectMapper object */
        ObjectMapper mapper = new ObjectMapper();
        System.out.println( mapper.writeValueAsString(sr.getGas()));
        return Flowable.interval(5, TimeUnit.SECONDS) .map(interval -> mapper.writeValueAsString(sr.getGas()));
    }


    /* Pollution stream */
    @Outgoing("pollution-stream")
    public Flowable <String> streamPollutionData() throws JsonProcessingException {
        /* Creating the ObjectMapper object */
        ObjectMapper mapper = new ObjectMapper();

        /* Converting the Gas object to JSONString */
        return Flowable.interval(5, TimeUnit.SECONDS).map(interval ->  mapper.writeValueAsString(sr.getPollution()));
    }
}
