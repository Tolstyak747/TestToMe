package com.Malkov.domain;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Component
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Device> devices;

    public Project() {
    }


    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int countEr(List<Device> devices) {
        int count = 0;
        for (Device d : devices) {
            if (d.hasError(d.getEvents())) {
                count++;
            }
        }
        return count;
    }

    public int countStbl(List<Device> devices) {
        int count = 0;
        for (Device d : devices) {
            if (d.stable(d.getEvents())) {
                count++;
            }
        }
        return count;
    }


    public List nameOfDevices(List<Device> devices) {
        List<String> name = new ArrayList<>();
        for (Device d : devices) {
            name.add(d.getSerialNumber());
        }
        return name;
    }


    @Override
    public String toString() {
        return "id: " + id + "\n" + "projectName: " + "'" + name + "'" + "\n" + "stats: {" + " \n" + "   deviceCount: " + this.devices.size() + ",\n" + "   deviceWithErrors: " + countEr(this.devices) + ",\n" + "   stableDevices=" + countStbl(this.devices) + ",\n" + "}" + ",\n" + "devices:" + nameOfDevices(this.devices) + "\n";

    }
}
