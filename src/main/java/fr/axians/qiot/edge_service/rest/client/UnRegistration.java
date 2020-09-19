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
import java.io.IOException;
import java.io.ObjectInputStream;


@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@Path("/unregister")
public class UnRegistration {

    @Inject
    @RestClient
    RegistrationService regService;
    @GET
    public int unregister(@PathParam("id") int id){

        /*Writing station object in file*/
        try {
            FileInputStream fi = new FileInputStream(new File("station.txt"));;
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read station object from file
            Station st2 = (Station) oi.readObject();
            oi.close();
            fi.close();

            regService.unregStation(st2.getId());
            return 0;

        } catch (FileNotFoundException e) {
            System.out.println("File not found, so I can't unregister this station");
            return 1;
        } catch (IOException e) {
            System.out.println(e);
            return 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

}
