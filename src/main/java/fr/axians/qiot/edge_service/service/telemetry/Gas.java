package fr.axians.qiot.edge_service.service.telemetry;

import java.time.Instant;

public class Gas {

    public Integer stationid;
    public Instant instant;
    public double adc;
    public double nh3;
    public double oxidising;
    public double reducing;

    public Integer getStationid() {
        return this.stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getInstant() {
        return this.instant;
    }

    public void setInstant(String instant) {
        this.instant = instant;
    }

    public double getAdc() {
        return this.adc;
    }

    public void setAdc(double adc) {
        this.adc = adc;
    }

    public double getNh3() {
        return this.nh3;
    }

    public void setNh3(double nh3) {
        this.nh3 = nh3;
    }

    public double getOxidising() {
        return this.oxidising;
    }

    public void setOxidising(double oxidising) {
        this.oxidising = oxidising;
    }

    public double getReducing() {
        return this.reducing;
    }

    public void setReducing(double reducing) {
        this.reducing = reducing;
    }

}
