package ru.test.demoPassengers.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.demoPassengers.model.Passenger;
import ru.test.demoPassengers.service.PassengerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/passengers")
@AllArgsConstructor
public class PassengersController {

   private final PassengerService service;

   @GetMapping
   public List<Passenger> findAllPassenger() {
       return service.findAllPassenger();
       //todo
   }
@GetMapping("/{firstname}")
   public Passenger findByFirstname(@PathVariable String firstname) {
       return service.findByFirstname(firstname);
   }
}
