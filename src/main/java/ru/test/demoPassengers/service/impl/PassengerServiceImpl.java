package ru.test.demoPassengers.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.test.demoPassengers.model.Passenger;
import ru.test.demoPassengers.repository.PassengerRepo;
import ru.test.demoPassengers.service.PassengerService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepo repo;
    @Override
    public List<Passenger> findAllPassenger() {
        return repo.findAll();
    }

    @Override
    public Passenger findByFirstname(String firstname) {
        return repo.findPassByFirstname(firstname);
    }

    @Override
    public Passenger findAllByAge(int age) {
        return repo.findAllByAge(age);
    }
}
