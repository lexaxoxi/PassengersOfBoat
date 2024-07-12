package ru.test.demoPassengers.service;

import ru.test.demoPassengers.dto.PassengerDTO;
import org.springframework.data.domain.Page;

public interface PassengerService {
    Page<PassengerDTO> findAllPassenger(PassengerDTO passengerDTO);
}
