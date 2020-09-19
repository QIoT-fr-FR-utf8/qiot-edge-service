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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


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

            Station st = new Station();
            st.setSerial("36c2a3079e97428fa514f2beb0fd4e6a");
            st.setName("FRutf8");
            st.setLongitude(2.3);
            st.setLatitude(48.8);

            int stationId;
            stationId = regService.regStation(st.getSerial(), st.getName(), st.getLongitude(), st.getLongitude());
            st.setId(stationId);
            st.setActive(true);

            /*Writing station object in file*/
            try {
                FileOutputStream f = new FileOutputStream(new File("station.txt"));
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(st);
                o.close();
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println(e);
            }

            return st.getId();
    }
}

