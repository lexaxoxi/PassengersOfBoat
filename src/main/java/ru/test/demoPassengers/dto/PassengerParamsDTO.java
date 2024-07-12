package ru.test.demoPassengers.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassengerParamsDTO implements Serializable {
    private String name;
    private boolean survived;
    private boolean adult;
    private boolean male;
    private boolean withoutRelatives;
    private int page;
    private int size;
    private String sortBy;
    private String sortDir;
}
