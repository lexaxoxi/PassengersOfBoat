package ru.test.demoPassengers.dto;

import lombok.Data;

@Data
public class StatDTO {
    private double totalFare;
    private int totalRelatives;
    private int totalSurvivors;
}