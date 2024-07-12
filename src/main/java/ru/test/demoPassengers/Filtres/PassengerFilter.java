package ru.test.demoPassengers.Filtres;

import org.springframework.data.jpa.domain.Specification;
import ru.test.demoPassengers.model.Passenger;

import java.util.List;
import java.util.Locale;

public class PassengerFilter {
    public static Specification<Passenger> findByName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase(Locale.ROOT) + "%");
    }

    public static Specification<Passenger> survivedEquals(boolean survived) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("survived"), survived);
    }

    public static Specification<Passenger> ageAdult(double age) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("age"), age);
    }

    public static Specification<Passenger> sexEquals(String sex) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("sex"), sex);
    }

    public static Specification<Passenger> siblingsSpousesAboardEquals(int siblingsSpousesAboard) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("siblingsSpousesAboard"), siblingsSpousesAboard);
    }

    public static Specification<Passenger> parentsChildrenAboardEquals(int parentsChildrenAboard) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("parentsChildrenAboard"), parentsChildrenAboard);
    }

    public static Specification<Passenger> combineFilters(List<Specification<Passenger>> specifications) {
        if (specifications == null || specifications.isEmpty()) {
            return null;
        }

        return specifications.stream()
                .reduce(Specification::and)
                .orElse(null);
    }
}