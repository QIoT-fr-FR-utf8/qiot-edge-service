package fr.axians.qiot.edge_service.rest.client.registration;

/* Main Import */
import java.io.Serializable;
import org.eclipse.microprofile.config.ConfigProvider;

public class Station implements Serializable  {

    private Integer id;
    private String serial;
    private String name;
    private Double longitude;
    private Double latitude;
    public Boolean active;

    public Station() {
        this.name = ConfigProvider.getConfig().getValue("team.name", String.class);
        this.longitude = ConfigProvider.getConfig().getValue("team.longitude", Double.class);
        this.latitude = ConfigProvider.getConfig().getValue("team.latitude", Double.class);
    }

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