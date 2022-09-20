package ru.evsyukov.shift_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "Hard_drives")
public final class HardDrive extends Product {

    @Column(name = "capacity", nullable = false)
    @Range(min = 0)
    private int capacity;
}
