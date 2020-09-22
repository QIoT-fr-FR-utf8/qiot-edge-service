package fr.axians.qiot.edge_service.service.sensor;

public class Result {
    public SensorResult result;

    public class SensorResult{
    
        public String instant;
        public Double nh3;
        public Double oxidising;
        public Double reducing;

    }

}