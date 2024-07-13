package ru.test.demoPassengers.dto;

import lombok.Data;

@Data
public class StatDTO {
    private double sumFare;
    private int sumRelatives;
    private int sumSurvivors;
}