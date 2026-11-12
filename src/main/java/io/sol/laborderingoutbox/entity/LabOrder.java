package io.sol.laborderingoutbox.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * This class represents the actual laboratory order.
 * it will then be associated with the OutboxEvent class
 */
@Entity
@Table(name = "lab_orders")
@Getter
@Setter
public class LabOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String patientId;
    private String testRequested;
    private Instant orderDate;
}
