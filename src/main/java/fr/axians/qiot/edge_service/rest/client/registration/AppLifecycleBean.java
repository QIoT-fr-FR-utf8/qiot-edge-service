package fr.axians.qiot.edge_service.rest.client.registration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import fr.axians.qiot.edge_service.service.registration.RegistrationService;
import fr.axians.qiot.edge_service.service.telemetry.TelemetryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;
import javax.ws.rs.Path;


/* Imports for Read File */
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

import org.eclipse.microprofile.config.inject.ConfigProperty;


//@Path("/register")
@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");
    private Station st;
    
    @ConfigProperty(name = "team.name")
    String name;

    @ConfigProperty(name = "team.longitude")
    Double longitude;

    @ConfigProperty(name = "team.latitude")
    Double latitude;

    @Inject
    TelemetryService tele;

    @Inject
    @RestClient
    RegistrationService regService; 

    @PostConstruct
    void init(){
        this.st = new Station();
        LOGGER.info(this.st.toString());
        
        //Defined the machine-id path to be able to regester
        java.nio.file.Path  path = Paths.get("/etc/machine-id");
        String content = null;

        //Get the id defined in the file
        try {
            content = Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error(e);
        };

        //Initialize the Station information
        this.st.setSerial(content);
        this.st.setName(name);
        this.st.setLongitude(longitude);
        this.st.setLatitude(latitude);
        LOGGER.info("Nom d equipe : "+this.st.getName());

        /* Retrieve stationId and activate the station */
        int stationId =0;
        stationId = regService.regStation(this.st.getSerial(), this.st.getName(), this.st.getLongitude(), this.st.getLatitude());
        this.st.setId(stationId);
        this.st.setActive(true);
        LOGGER.info("Register ID : "+this.st.getId());
    }

     /**
     * At the begining of the application we set the required information
     * and regester.
     */
    void onStart(@Observes StartupEvent ev) {               
        LOGGER.info("Application started.");
    }

    /**
     * At the end of the application we unregister
     */
    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("Stop application begin uregistering process ...");               
        regService.unregStation(this.st.getId());
    }

    void run() { 
        

        try { 
            tele.streamGasData();
        } catch (JsonProcessingException e) { 
            LOGGER.error("An error occurred retrieving GAS maeasurement", e); 
        }

        try { 
            tele.streamPollutionData();
        } catch (JsonProcessingException e) { 
            LOGGER.error( 
            "An error occurred retrieving Particulates maeasurement", e);
        }
    }

    
    //@GET
    //@Path("/id")
    //@Produces(MediaType.TEXT_PLAIN)
    public int getRegistrationId(){
        return this.st.getId();
    }

}