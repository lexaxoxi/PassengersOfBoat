package ru.test.demoPassengers.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassengerDTO implements Serializable {
    private boolean survived;
    private String pclass;
    private String name;
    private String sex;
    private double age;
    private int siblingsSpousesAboard;
    private int parentsChildrenAboard;
    private double fare;
}
