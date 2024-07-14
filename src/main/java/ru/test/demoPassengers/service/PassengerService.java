package ru.test.demoPassengers.service;

import org.springframework.cache.annotation.Cacheable;
import ru.test.demoPassengers.dto.PassengerDTO;
import org.springframework.data.domain.Page;
import ru.test.demoPassengers.dto.PassengerParamsDTO;

public interface PassengerService {
    @Cacheable(value = "Page<PassengerDTO>",
            key = "#paramsDTO.name + '-' + " +
                    "#paramsDTO.page + '-' + " +
                    "#paramsDTO.size + '-' + " +
                    "#paramsDTO.sortBy + '-' + " +
                    "#paramsDTO.sortDir + '-' + " +
                    "#paramsDTO.adult  + '-' + " +
                    "#paramsDTO.male + '-' + " +
                    "#paramsDTO.withoutRelatives + '-' + " +
                    "#paramsDTO.survived",
            condition = "#paramsDTO.name == null || #paramsDTO.name.blank")
    Page<PassengerDTO> findPassenger(PassengerParamsDTO paramsDTO);

    Page<PassengerDTO> findAllPassenger(PassengerDTO passengerDTO);
}
