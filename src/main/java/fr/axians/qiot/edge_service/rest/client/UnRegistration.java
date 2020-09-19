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
import fr.axians.qiot.edge_service.rest.client.Station;


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

            // Read objects
            Station st2 = (Station) oi.readObject();
            oi.close();
            fi.close();

            System.out.println(st2.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return 0;
    }

}
