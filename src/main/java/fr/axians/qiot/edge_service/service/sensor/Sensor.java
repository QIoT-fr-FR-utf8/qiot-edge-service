package fr.axians.qiot.edge_service.service.sensor;

public abstract class Sensor {
    protected int stationId;

    

    public int getStationId(){
        return this.stationId;
    }

    public void setStationId(int stId){
        this.stationId = stId;
    }



}