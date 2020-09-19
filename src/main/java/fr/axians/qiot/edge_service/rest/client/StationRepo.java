package fr.axians.qiot.edge_service.rest.client;

import fr.axians.qiot.edge_service.rest.client.Station;

public class StationRepo {
    Station st = null;
    public Station findStationbyId(int stationId){
        if (st.getId() == null)
            return null;
        return st;
    }
}
