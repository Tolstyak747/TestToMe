package com.Malkov.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Component
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private EventType type;
    @Column(name = "is_read")
    private boolean isRead;
    @ManyToOne
    private Device device;

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", type=" + type +
                ", isRead=" + isRead +
                '}';
    }
}
