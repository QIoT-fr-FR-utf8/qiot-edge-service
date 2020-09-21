package fr.axians.qiot.edge_service.service.sensor;

import java.util.List;
import java.io.Serializable;

public class Result implements Serializable{
    public SensorResult result;

  
    public class SensorResult implements Serializable{
    
        public String instant;
        public Double nh3;
        public Double oxidising;
        public Double reducing;

    }

}