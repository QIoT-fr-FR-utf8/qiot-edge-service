package fr.axians.qiot.edge_service.service.sensor;
import java.io.Serializable;

public abstract class Sensor implements Serializable{
    private static final long serialVersionUID = 1L;
    protected int stationId;

    

    public int getStationId(){
        return this.stationId;
    }

    public void setStationId(int stId){
        this.stationId = stId;
    }


    public Sensor() {
    }

    public Sensor(int stationId) {
        this.stationId = stationId;
    }

    public Sensor stationId(int stationId) {
        this.stationId = stationId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sensor)) {
            return false;
        }
        Sensor sensor = (Sensor) o;
        return stationId == sensor.stationId;
    }

    @Override
    public String toString() {
        return "{" +
            " stationId='" + getStationId() + "'" +
            "}";
    }


}