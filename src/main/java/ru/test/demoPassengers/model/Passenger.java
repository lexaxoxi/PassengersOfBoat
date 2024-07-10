package ru.test.demoPassengers.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String firstname;
    private String lastname;
    private String otchestvo;
    private int age;
}
