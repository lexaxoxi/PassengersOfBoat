package ru.test.demoPassengers.service;

import ru.test.demoPassengers.dto.StatDTO;
import ru.test.demoPassengers.dto.StatParamsDTO;

public interface StatService {
    StatDTO getStat(StatParamsDTO paramsDTO);
}
