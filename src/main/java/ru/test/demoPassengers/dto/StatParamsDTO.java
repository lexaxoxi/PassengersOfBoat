package ru.test.demoPassengers.dto;

import lombok.Data;

@Data
public class StatParamsDTO {
    private String name;
    private boolean survived;
    private boolean adult = false;
    private boolean male = false;
    private boolean withoutRelatives = false;
}
