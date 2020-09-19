package fr.axians.qiot.edge_service.service;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface RegistrationService {

    int register(String serial, String name, double longitude, double latitude);

}