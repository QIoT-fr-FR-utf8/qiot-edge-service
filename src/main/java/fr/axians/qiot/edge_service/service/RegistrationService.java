package fr.axians.qiot.edge_service.service;

public interface RegistrationService {

    int register(String serial, String name, double longitude, double latitude);

}