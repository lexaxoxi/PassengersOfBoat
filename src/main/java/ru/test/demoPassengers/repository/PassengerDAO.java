package ru.test.demoPassengers.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import ru.test.demoPassengers.model.Passenger;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PassengerDAO {
    private final List<Passenger> PASSENGERS= new ArrayList<>();

    public List<Passenger> findAllPassenger() {
        return PASSENGERS;
    }


    public Passenger findByFirstname(String firstname) {
        return PASSENGERS.stream()
                .filter(element -> element.getFirstname().equals(firstname))
                .findAny()
                .orElse(null);
    }

//    public Passenger findAllByAge(int age) {
//        return PASSENGERS.stream()
//                .filter(element -> element.getAge())
//                .;
//    }
}
