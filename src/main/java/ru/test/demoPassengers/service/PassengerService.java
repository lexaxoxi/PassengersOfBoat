package ru.test.demoPassengers.service;

import org.springframework.stereotype.Service;
import ru.test.demoPassengers.model.Passenger;

import java.util.List;


public interface PassengerService {
    List<Passenger> findAllPassenger();
    Passenger findByFirstname(String firstname);
    Passenger findAllByAge(int age);
}
