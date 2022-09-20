package ru.evsyukov.shift_backend.entity.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LaptopDiagonalConstraintValidator
    implements ConstraintValidator<LaptopDiagonalConstraint, Integer> {

    private static final Set<Integer> acceptableDiagonals = new HashSet<>(List.of(13, 14, 15, 17));

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && acceptableDiagonals.contains(integer);
    }
}
