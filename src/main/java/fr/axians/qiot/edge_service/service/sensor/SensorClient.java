package fr.axians.qiot.edge_service.service.sensor;

import java.text.DateFormat;
import java.util.List;

public class SensorClient {


    public String type;
    public List<Result> results;

    public static class Result {
        public DateFormat instant;
        public Double nh3;
        public Double oxidising;
        public Double reducing;
    }

}