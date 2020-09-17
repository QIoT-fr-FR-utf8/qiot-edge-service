package fr.axians.qiot.edge_service.service.sensor;

import java.util.List;

public class GazResult {

    private String instant;
    private Double nh3;
    private Double oxidising;
    private Double reducing;

    public String getInstant() {
        return this.instant;
    }

    public Double getNh3() {
        return this.nh3;
    }

    public Double getOxidising() {
        return this.oxidising;
    }

    public Double getReducing() {
        return this.reducing;
    }

    private GazResult(String instant, Double nh3, Double oxidising, Double reducing) {
        this.instant = instant;
        this.nh3 = nh3;
        this.oxidising = oxidising;
        this.reducing = reducing;
    }
    
    public static GazResult of(Gaz gaz, GazSensor gazsensor) {
        return new GazResult(
            gaz.instant,
            gaz.nh3,
            gaz.oxidising,
            gaz.reducing);
    }

}