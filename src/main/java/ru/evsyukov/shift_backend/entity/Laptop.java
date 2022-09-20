package ru.evsyukov.shift_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.evsyukov.shift_backend.entity.validation.LaptopDiagonalConstraint;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Laptops")
public final class Laptop extends Product {

    @Column(name = "diagonal", nullable = false)
    @LaptopDiagonalConstraint
    private int diagonal;
}
