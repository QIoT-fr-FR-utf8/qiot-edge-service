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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/* Access on : IP:8080/unregister */
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
@Path("/unregister")
public class UnRegistration {

    @Inject
    @RestClient
    RegistrationService regService;
    @GET
    public int unregister(@PathParam("id") int id){

        /* Reading station object from file */
        try {
            FileInputStream fi = new FileInputStream(new File("station.txt"));;
            ObjectInputStream oi = new ObjectInputStream(fi);

            /* Read station object from file */
            Station st = (Station) oi.readObject();
            oi.close();
            fi.close();

            /* Unregistration of the station */
            regService.unregStation(st.getId());
            return 0;

        } catch (FileNotFoundException e) {
            System.out.println("File not found, can't unregister this station");
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
