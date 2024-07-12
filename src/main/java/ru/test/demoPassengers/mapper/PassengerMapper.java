package ru.test.demoPassengers.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import ru.test.demoPassengers.dto.PassengerDTO;
import ru.test.demoPassengers.model.Passenger;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerDTO passengerToPassengerDTO(Passenger passenger);

    List<PassengerDTO> passengersToPassengerDTOs(List<Passenger> passenger);

    default Page<PassengerDTO> passengerPageToPassengerDTOPage(Page<Passenger> passengerPage) {
        List<PassengerDTO> passengerDTOList = this.passengersToPassengerDTOs(passengerPage.getContent());
        return new PageImpl<>(passengerDTOList, passengerPage.getPageable(), passengerPage.getTotalElements());
    }
}
