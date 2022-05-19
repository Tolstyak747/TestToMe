package com.Malkov.domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Component
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "serial_number")
    private String serialNumber;
    @ManyToOne
    private Project project;
    @OneToMany(mappedBy = "device", fetch = FetchType.EAGER)
    private List<Event> events;

    public Device() {
    }


    public List<Event> getEvents() {
        return events;
    }

    public boolean hasError(List<Event> events) {
        for (Event ev : events
        ) {
            if (ev.getType() == EventType.ERROR || ev.getType() == EventType.WARNING) {
                LocalDate now = LocalDate.now();
                if (Period.between(ev.getDate(), now).getDays() == 0) {
                    return true;
                }

            }

        }
        return false;
    }

    public boolean stable(List<Event> events) {
        for (Event ev : events
        ) {
            if (ev.getType() == EventType.WARNING || ev.getType() == EventType.ERROR) {
                return false;
            }
        }
        return true;
    }


    public String eventInfo(List<Event> events) {
        int error = 0;
        int warning = 0;
        int event = 0;

        for (Event ev : events
        ) {
            if (ev.getType() == EventType.ERROR) {
                error++;
            } else if (ev.getType() == EventType.WARNING) {
                warning++;
            } else event++;
        }
        return "eventCount: " + event + "\n" +
                "warningCount: " + warning + "\n" +
                "errorCount: " + error;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    public Project getProjects() {
        return project;
    }

    public void setProjects(Project project) {
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "'" + serialNumber + "'" + "\n" +
                "   id: " + id + "\n" +
                "   serialNumber: " + serialNumber + "\n" +
                "   projectId: " + this.project.getId() + "\n" +
                "   hasErrors: " + hasError(getEvents()) + "\n" +
                "   summaryInfo: " + "\n" +
                eventInfo(getEvents()) + "\n";
    }
}
