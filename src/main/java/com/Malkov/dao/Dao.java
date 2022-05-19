package com.Malkov.dao;

import com.Malkov.domain.Device;
import com.Malkov.domain.Event;
import com.Malkov.domain.Project;

import java.util.List;

public interface Dao {

    void addProject(Project project);

    void addDevice(Device device);

    void addEvent(Event event);

    void updateProject(Project project);

    void updateDevice(Device device);

    void updateEvent(Event event);

    Project getProjectById(int id);

    List<Project> listProject();

    Device getDeviceById(int id);

    Event getEventById(int id);

    List<Device> listDevice();

    void removeProject(Project project);
    void removeEvent(Event event);
    void removeDevice(Device device);


}
