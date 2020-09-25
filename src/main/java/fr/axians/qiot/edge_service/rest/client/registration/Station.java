package fr.axians.qiot.edge_service.rest.client.registration;

/* Main Import */
import java.io.Serializable;

import org.eclipse.microprofile.config.inject.ConfigProperty;

public class Station implements Serializable  {

    public Integer id;
    public String serial;

    //@ConfigProperty(name = "team.name")
    String name;

    //@ConfigProperty(name = "team.longitude")
    Double longitude;

    //@ConfigProperty(name = "team.latitude")
    Double latitude;

    public Boolean active;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return this.serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}