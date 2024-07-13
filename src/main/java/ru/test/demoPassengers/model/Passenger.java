package ru.test.demoPassengers.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Arrays;

@Data
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean survived;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Pclass pclass;
    @NotNull
    private String name;
    @NotNull
    private String sex;
    private double age;
    private int siblingsSpousesAboard;
    private int parentsChildrenAboard;
    private double fare;

    public enum Pclass {
        FIRST(1), SECOND(2), THIRD(3);
        private final int id;

        Pclass(int id) {
            this.id = id;
        }

    public static Pclass getById(int id) {
            return Arrays.stream(Pclass.values())
                    .filter(pclass->pclass.id == id)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Не найден класс пассажира" + id));
        }
    }
}