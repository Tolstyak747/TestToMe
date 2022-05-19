package com.Malkov.domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Component
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

    public Event(LocalDate date, EventType type, boolean isRead, Device device) {
        this.date = date;
        this.type = type;
        this.isRead = isRead;
        this.device = device;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Device getDevices() {
        return device;
    }

    public void setDevices(Device device) {
        this.device = device;
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
