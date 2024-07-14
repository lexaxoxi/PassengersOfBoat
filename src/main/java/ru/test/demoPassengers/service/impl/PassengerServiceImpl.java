package ru.test.demoPassengers.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.test.demoPassengers.dto.PassengerDTO;
import ru.test.demoPassengers.dto.PassengerParamsDTO;
import ru.test.demoPassengers.mapper.PassengerMapper;
import ru.test.demoPassengers.model.Passenger;
import ru.test.demoPassengers.repository.PassengerRepo;
import ru.test.demoPassengers.service.PassengerService;

import java.util.ArrayList;
import java.util.List;

import static ru.test.demoPassengers.Filtres.PassengerFilter.*;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepo repo;
    private final PassengerMapper mapper;
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
    @Override
    public Page<PassengerDTO> findPassenger(PassengerParamsDTO paramsDTO) {
        final Pageable pageable = PageRequest
                .of(paramsDTO.getPage(), paramsDTO.getSize(), Sort.by(Sort.Direction.fromString(paramsDTO.getSortDir()), paramsDTO.getSortBy()));
        final List<Specification<Passenger>> specificationList = new ArrayList<>();
        if (paramsDTO.isAdult())
            specificationList.add(ageAdult(18));
        if (StringUtils.hasText(paramsDTO.getName()))
            specificationList.add(findByName(paramsDTO.getName()));
        if (paramsDTO.isMale())
            specificationList.add(sexEquals("male"));
        if (paramsDTO.isWithoutRelatives()) {
            specificationList.add(parentsChildrenAboardEquals(0));
            specificationList.add(siblingsSpousesAboardEquals(0));
        }
        if (paramsDTO.isSurvived())
            specificationList.add(survivedEquals(true));
        // Combine specificationList (AND) for the final database query
        final var finalSpecification = combineFilters(specificationList);
        return mapper.passengerPageToPassengerDTOPage(repo.findAll(finalSpecification, pageable));
    }

    @Override
    public Page<PassengerDTO> findAllPassenger(PassengerDTO passengerDTO) {
        return null;
    }
}