package fr.axians.qiot.edge_service.service.telemetry;

import org.eclipse.microprofile.reactive.messaging.Outgoing;


public class TelemetryService {

    /* Pollution stream */
    @Outgoing("gas-stream")
    public String streamData(String data) {
        return data;
        }
}
