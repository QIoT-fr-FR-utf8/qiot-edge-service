package fr.axians.qiot.edge_service.rest.client.registration;

/* Main Imports */
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/* Import of RegistrationService */
import fr.axians.qiot.edge_service.service.registration.RegistrationService;

/* Imports for FileStream */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* Imports for Read File */
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

/* Access on : IP:8080/register */
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@Path("/register")
public class Registration {

    @Inject
    @RestClient
    RegistrationService regService;

    @GET
    public int register(@PathParam("serial") String serial,
    @PathParam("name") String name,
    @PathParam("longitude") double longitude,
    @PathParam("latitude") double latitude) {

            /* Initialize Station object. Note for the future : values ​​will not be initialized in the code */
            Station st = new Station();
            //st.setSerial("36c2a3079e97428fa514f2beb0fd4e6a");
            java.nio.file.Path  path = Paths.get("/etc/machine-id");
            String content = null;
            try {
                content = Files.readString(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.out.println(e);
            };
            st.setSerial(content);
            st.setName("FRutf81");
            st.setLongitude(2.3);
            st.setLatitude(48.8);

            /* Retrieve stationId and activate the station */
            int stationId;
            stationId = regService.regStation(st.getSerial(), st.getName(), st.getLongitude(), st.getLongitude());
            st.setId(stationId);
            st.setActive(true);

            /* Writing station object in file */
            try {
                FileOutputStream f = new FileOutputStream(new File("station.txt"));
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(st);
                o.close();
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found, can't register this station");
            } catch (IOException e) {
                System.out.println(e);
            }

            /* Return the stationId of this station */
            return st.getId();
    }
}

