package fr.axians.qiot.edge_service.service;

@ApplicationScoped
public interface RegistrationService {

    int register(String serial, String name, double longitude, double latitude);

}