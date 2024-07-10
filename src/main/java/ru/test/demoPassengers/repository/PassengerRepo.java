package ru.test.demoPassengers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.demoPassengers.model.Passenger;

//12120
public interface PassengerRepo extends JpaRepository<Passenger, Long> {

    Passenger findPassByFirstname(String firstname);

    Passenger findAllByAge(int age);

}
