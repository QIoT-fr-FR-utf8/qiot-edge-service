package fr.axians.qiot.edge_service.service.sensor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GasSensor {
    private Gas gas;

    GasSensor(Gas gas) {
        this.gas = gas;
    }

    @JsonCreator
    public static GasSensor of(Gas gas) {
        return new GasSensor(gas);
    }

    public static class Gas {
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

        @JsonCreator
        Gas(String instant, Double nh3, Double oxidising, Double reducing) {
            this.instant = instant;
            this.nh3 = nh3;
            this.oxidising = oxidising;
            this.reducing = reducing;
        }

        @JsonCreator
        public static Gas of(String instant, Double nh3, Double oxidising, Double reducing) {
            return new Gas(instant, nh3, oxidising, reducing);
        }
    }

}