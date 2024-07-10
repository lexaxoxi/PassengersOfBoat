package ru.test.demoPassengers.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.demoPassengers.model.Passenger;
import ru.test.demoPassengers.repository.PassengerDAO;
import ru.test.demoPassengers.service.PassengerService;

import java.util.List;

@Service
@AllArgsConstructor
public class PassengerInMemServiceImpl implements PassengerService {
    private final PassengerDAO repository;

    @Override
    public List<Passenger> findAllPassenger() {
        return repository.findAllPassenger();
    }

    @Override
    public Passenger findByFirstname(String firstname) {
        return repository.findByFirstname(firstname);
    }
//todo
    @Override
    public Passenger findAllByAge(int age) {
     return null;

      }
    }
