package io.sol.laborderingoutbox.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "outbox_events")
@Getter
@Setter
public class OutboxEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eventId;

    @Column(columnDefinition = "TEXT")
    private String payload;

    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String EventType;

    @PrePersist
    public void prePersist(){
        if(this.createdAt == null){
            this.createdAt = Instant.now();
        }
        if(this.status == null){
            this.status = Status.PENDING;
        }
    }
}
