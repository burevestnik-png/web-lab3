package ru.yofik.lab3.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "results")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public final class Result implements Serializable {
    private static final long UID = 1L;


    @Id
    @SequenceGenerator(sequenceName = "result_id_seq", name = "result_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_id_seq")
    private long id;

    @Column(nullable = false)
    private double x;

    @Column(nullable = false)
    private double y;

    @Column(nullable = false)
    private double r;

    @Column(nullable = false)
    private boolean isHit;

    @Column(nullable = false)
    private Date currentTime;
}
