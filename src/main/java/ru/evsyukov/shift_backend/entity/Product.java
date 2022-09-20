package ru.evsyukov.shift_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Products")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    @Column(name = "serial_number", nullable = false)
    @NotBlank
    protected String serialNumber;

    @Column(name = "producer", nullable = false)
    @NotBlank
    protected String producer;

    @Column(name = "price", nullable = false)
    @Range(min = 0)
    protected double price;

    @Column(name = "quantity_in_storage", nullable = false)
    @Range(min = 0)
    protected int quantityInStorage;
}
