package ru.test.demoPassengers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.test.demoPassengers.model.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer>, JpaSpecificationExecutor<Passenger> {

}
