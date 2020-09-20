package fr.axians.qiot.edge_service.service.telemetry;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;

/* Imports for FileStream */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import fr.axians.qiot.edge_service.rest.client.registration.Station;

public class TelemetryService {

    Gas gtest = new Gas();

    /* Gas stream */
    @Outgoing("gas-stream")
    public Flowable <Gas> streamData() {

        /* Initializing gas object with test values */

        gtest.setInstant("2020-09-20T14:00:00.002818Z");
        gtest.setAdc(128431.13772455092);
        gtest.setNh3(192387.0967741936);
        gtest.setOxidising(10594.594594594595);
        gtest.setReducing(192387.0967741936);

        /* Reading station object from file */
        try {
            FileInputStream fi = new FileInputStream(new File("station.txt"));;
            ObjectInputStream oi = new ObjectInputStream(fi);

            /* Read station object from file */
            Station st = (Station) oi.readObject();
            oi.close();
            fi.close();

            /* Adding stationId on gas object */
            //int stationId;
            //stationId = st.getId();
            gtest.setStationid(12);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /* Send data every 5 seconds */
        return Flowable.interval(5, TimeUnit.SECONDS)
        .map(tick -> gtest);
        }
}
