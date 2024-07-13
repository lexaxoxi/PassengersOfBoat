package ru.test.demoPassengers.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.demoPassengers.dto.PassengerDTO;
import ru.test.demoPassengers.dto.PassengerParamsDTO;
import ru.test.demoPassengers.service.impl.PassengerServiceImpl;

@RestController
@RequestMapping("api/v1/passengers")
@AllArgsConstructor
public class PassengersController {

   private final PassengerServiceImpl service;

   @GetMapping
   public Page<PassengerDTO> findAllPassenger(
       @RequestParam(required = false, defaultValue = "0") int page,
       @RequestParam(required = false, defaultValue = "50") int size,
       @RequestParam(required = false, defaultValue = "name") String sortBy,
       @RequestParam(required = false, defaultValue = "asc") String sortDir,
       @RequestParam(required = false) Boolean adult,
       @RequestParam(required = false) Boolean male,
       @RequestParam(required = false) Boolean withoutRelative,
       @RequestParam(required = false) Boolean survived,
       @RequestParam(required = false) String name) {
           PassengerParamsDTO paramsDTO = new PassengerParamsDTO();
           paramsDTO.setPage(page);
           paramsDTO.setSize(size);
           paramsDTO.setSortBy(sortBy);
           paramsDTO.setSortDir(sortDir);
           paramsDTO.setAdult(adult != null ? adult : false);
           paramsDTO.setMale(male != null ? male : false);
           paramsDTO.setWithoutRelatives(withoutRelative != null ? withoutRelative : false);
           paramsDTO.setSurvived(survived != null ? survived : false);
           paramsDTO.setName(name);
           return service.findPassenger(paramsDTO);
       }
}
