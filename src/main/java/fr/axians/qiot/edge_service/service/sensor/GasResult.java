package fr.axians.qiot.edge_service.service.sensor;

public class GasResult extends Sensor{

    public String instant;
    public Double nh3;
    public Double oxidising;
    public Double reducing;

    public GasResult(int id, String instant, Double nh3, Double oxidising, Double reducing){
        this.stationId = id;
        this.instant = instant;
        this.nh3 = nh3;
        this.oxidising = oxidising;
        this.reducing = reducing;
    }
}