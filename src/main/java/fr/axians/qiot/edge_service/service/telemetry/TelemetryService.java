// package fr.axians.qiot.edge_service.service.telemetry;

// import org.eclipse.microprofile.reactive.messaging.Outgoing;
// import io.reactivex.Flowable;
// import java.util.concurrent.TimeUnit;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import java.time.Instant;

// /* Imports for FileStream */
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.io.ObjectInputStream;

// import fr.axians.qiot.edge_service.rest.client.registration.Station;

// public class TelemetryService {

//     /* Objects creation */
//     Gas gtest = new Gas();
//     Pollution ptest = new Pollution();

//     /* Gas stream */
//     @Outgoing("gas-stream")
//     public Flowable <String> streamGasData() throws JsonProcessingException {

//         Instant instant = Instant.now();
//         String time = instant.toString();

//         /* Initializing gas object with test values */

//         gtest.setInstant(time);
//         gtest.setAdc(128431.13772455092);
//         gtest.setNh3(192387.0967741936);
//         gtest.setOxidising(10594.594594594595);
//         gtest.setReducing(192387.0967741936);

//         /* Reading station object from file */
//         try {
//             FileInputStream fi = new FileInputStream(new File("station.txt"));;
//             ObjectInputStream oi = new ObjectInputStream(fi);

//             /* Read station object from file */
//             Station st = (Station) oi.readObject();
//             oi.close();
//             fi.close();

//             /* Adding stationId on gas object */
//             //int stationId;
//             //stationId = st.getId();
//             gtest.setStationid(12);

//         } catch (FileNotFoundException e) {
//             System.out.println("File not found");
//         } catch (IOException e) {
//             System.out.println(e);
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }

//         /* Creating the ObjectMapper object */
//         ObjectMapper mapper = new ObjectMapper();

//         /* Converting the Gas object to JSONString */
//         String jsonString = mapper.writeValueAsString(gtest);
//         System.out.println(jsonString);

//         /* Send data every 5 seconds */
//         return Flowable.interval(5, TimeUnit.SECONDS)
//         .map(tick -> jsonString);
//         }


//     /* Pollution stream */
//     @Outgoing("pollution-stream")
//     public Flowable <String> streamPollutionData() throws JsonProcessingException {

//         Instant instantp = Instant.now();
//         String timep = instantp.toString();

//         /* Initializing pollution object with test values */

//         ptest.setInstant(timep);
//         ptest.setPM1_0(240);
//         ptest.setPM2_5(156);
//         ptest.setPM10(114);
//         ptest.setPM1_0_atm(81);
//         ptest.setPM2_5_atm(204);
//         ptest.setPM10_atm(134);
//         ptest.setGt0_3um(21366);
//         ptest.setGt0_5um(5774);
//         ptest.setGt1_0um(14);
//         ptest.setGt2_5um(1355);
//         ptest.setGt5_0um(126);
//         ptest.setGt10um(59);

//         /* Reading station object from file */
//         try {
//             FileInputStream fip = new FileInputStream(new File("station.txt"));;
//             ObjectInputStream oip = new ObjectInputStream(fip);

//             /* Read station object from file */
//             Station stp = (Station) oip.readObject();
//             oip.close();
//             fip.close();

//             /* Adding stationId on pollution object */
//             //int stationId;
//             //stationId = st.getId();
//             ptest.setStationid(12);

//         } catch (FileNotFoundException e) {
//             System.out.println("File not found");
//         } catch (IOException e) {
//             System.out.println(e);
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }

//         /* Creating the ObjectMapper object */
//         ObjectMapper mapperp = new ObjectMapper();

//         /* Converting the Pollution object to JSONString */
//         String jsonStringp = mapperp.writeValueAsString(ptest);
//         System.out.println(jsonStringp);

//         /* Send data every 5 seconds */
//         return Flowable.interval(5, TimeUnit.SECONDS)
//         .map(tick -> jsonStringp);
//         }
// }
