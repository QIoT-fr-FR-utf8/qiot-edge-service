package fr.axians.qiot.edge_service.service.sensor;

public class PollutionResult extends Sensor {

    public Integer PM10;
    public Integer PM10_atm;
    public Integer PM1_0;
    public Integer PM1_0_atm;
    public Integer PM2_5;
    public Integer PM2_5_atm;
    public Integer gt0_3um;
    public Integer gt0_5um;
    public Integer gt10um;
    public Integer gt1_0um;
    public Integer gt2_5um;
    public Integer gt5_0um;
    public String instant;
    
    public PollutionResult(int id, Integer PM10,Integer PM10_atm,Integer PM1_0,Integer PM1_0_atm,Integer PM2_5,Integer PM2_5_atm,Integer gt0_3um,Integer gt0_5um,Integer gt10um,Integer gt1_0um,Integer gt2_5um,Integer gt5_0um, String instant){
        this.stationId = id;
        this.PM10 = PM10;
        this.PM10_atm = PM10_atm;
        this.PM1_0 = PM1_0;
        this.PM1_0_atm = PM1_0_atm ;
        this.PM2_5 = PM2_5;
        this.PM2_5_atm = PM2_5_atm;
        this.gt0_3um = gt0_3um;
        this.gt0_5um = gt0_5um;
        this.gt10um = gt10um;
        this.gt1_0um = gt1_0um;
        this.gt2_5um = gt2_5um;
        this.gt5_0um = gt5_0um ;
        this.instant = instant;
    }


    public PollutionResult() {
    }



    public Integer getPM10() {
        return this.PM10;
    }

    public void setPM10(Integer PM10) {
        this.PM10 = PM10;
    }

    public Integer getPM10_atm() {
        return this.PM10_atm;
    }

    public void setPM10_atm(Integer PM10_atm) {
        this.PM10_atm = PM10_atm;
    }

    public Integer getPM1_0() {
        return this.PM1_0;
    }

    public void setPM1_0(Integer PM1_0) {
        this.PM1_0 = PM1_0;
    }

    public Integer getPM1_0_atm() {
        return this.PM1_0_atm;
    }

    public void setPM1_0_atm(Integer PM1_0_atm) {
        this.PM1_0_atm = PM1_0_atm;
    }

    public Integer getPM2_5() {
        return this.PM2_5;
    }

    public void setPM2_5(Integer PM2_5) {
        this.PM2_5 = PM2_5;
    }

    public Integer getPM2_5_atm() {
        return this.PM2_5_atm;
    }

    public void setPM2_5_atm(Integer PM2_5_atm) {
        this.PM2_5_atm = PM2_5_atm;
    }

    public Integer getGt0_3um() {
        return this.gt0_3um;
    }

    public void setGt0_3um(Integer gt0_3um) {
        this.gt0_3um = gt0_3um;
    }

    public Integer getgt0_5um() {
        return this.gt0_5um;
    }

    public void setgt0_5um(Integer gt0_5um) {
        this.gt0_5um = gt0_5um;
    }

    public Integer getGt10um() {
        return this.gt10um;
    }

    public void setGt10um(Integer gt10um) {
        this.gt10um = gt10um;
    }

    public Integer getGt1_0um() {
        return this.gt1_0um;
    }

    public void setGt1_0um(Integer gt1_0um) {
        this.gt1_0um = gt1_0um;
    }

    public Integer getGt2_5um() {
        return this.gt2_5um;
    }

    public void setGt2_5um(Integer gt2_5um) {
        this.gt2_5um = gt2_5um;
    }

    public Integer getGt5_0um() {
        return this.gt5_0um;
    }

    public void setGt5_0um(Integer gt5_0um) {
        this.gt5_0um = gt5_0um;
    }

    public String getInstant() {
        return this.instant;
    }

    public void setInstant(String instant) {
        this.instant = instant;
    }

    public PollutionResult PM10(Integer PM10) {
        this.PM10 = PM10;
        return this;
    }

    public PollutionResult PM10_atm(Integer PM10_atm) {
        this.PM10_atm = PM10_atm;
        return this;
    }

    public PollutionResult PM1_0(Integer PM1_0) {
        this.PM1_0 = PM1_0;
        return this;
    }

    public PollutionResult PM1_0_atm(Integer PM1_0_atm) {
        this.PM1_0_atm = PM1_0_atm;
        return this;
    }

    public PollutionResult PM2_5(Integer PM2_5) {
        this.PM2_5 = PM2_5;
        return this;
    }

    public PollutionResult PM2_5_atm(Integer PM2_5_atm) {
        this.PM2_5_atm = PM2_5_atm;
        return this;
    }

    public PollutionResult gt0_3um(Integer gt0_3um) {
        this.gt0_3um = gt0_3um;
        return this;
    }

    public PollutionResult gt0_5um(Integer gt0_5um) {
        this.gt0_5um = gt0_5um;
        return this;
    }

    public PollutionResult gt10um(Integer gt10um) {
        this.gt10um = gt10um;
        return this;
    }

    public PollutionResult gt1_0um(Integer gt1_0um) {
        this.gt1_0um = gt1_0um;
        return this;
    }

    public PollutionResult gt2_5um(Integer gt2_5um) {
        this.gt2_5um = gt2_5um;
        return this;
    }

    public PollutionResult gt5_0um(Integer gt5_0um) {
        this.gt5_0um = gt5_0um;
        return this;
    }

    public PollutionResult instant(String instant) {
        this.instant = instant;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " PM10='" + getPM10() + "'" +
            ", PM10_atm='" + getPM10_atm() + "'" +
            ", PM1_0='" + getPM1_0() + "'" +
            ", PM1_0_atm='" + getPM1_0_atm() + "'" +
            ", PM2_5='" + getPM2_5() + "'" +
            ", PM2_5_atm='" + getPM2_5_atm() + "'" +
            ", gt0_3um='" + getGt0_3um() + "'" +
            ", gt0_5um='" + getgt0_5um() + "'" +
            ", gt10um='" + getGt10um() + "'" +
            ", gt1_0um='" + getGt1_0um() + "'" +
            ", gt2_5um='" + getGt2_5um() + "'" +
            ", gt5_0um='" + getGt5_0um() + "'" +
            ", instant='" + getInstant() + "'" +
            "}";
    }

    
}