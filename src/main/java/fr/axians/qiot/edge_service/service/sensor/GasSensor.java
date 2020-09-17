package fr.axians.qiot.edge_service.service.sensor;

import java.util.List;

public class GasSensor {
    private Gas gas;

    GasSensor(Gas gas) {
        this.gas = gas;
    }

    public static class Gas {
        private String instant;
        private Double nh3;
        private Double oxidising;
        private Double reducing;

        public String getInstant() {
            return this.instant;
        }

        public void setInstant(String instant) {
            this.instant = instant;
        }

        public Double getNh3() {
            return this.nh3;
        }

        public void setNh3(Double nh3) {
            this.nh3 = nh3;
        }

        public Double getOxidising() {
            return this.oxidising;
        }

        public void setOxidising(Double oxidising) {
            this.oxidising = oxidising;
        }

        public Double getReducing() {
            return this.reducing;
        }

        public void setReducing(Double reducing) {
            this.reducing = reducing;
        }

        Gas(String instant, Double nh3, Double oxidising, Double reducing) {
            this.instant = instant;
            this.nh3 = nh3;
            this.oxidising = oxidising;
            this.reducing = reducing;
        }
    }

}