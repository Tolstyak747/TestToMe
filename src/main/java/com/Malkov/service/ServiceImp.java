package com.Malkov.service;

import com.Malkov.dao.Dao;
import com.Malkov.dao.DaoImp;
import com.Malkov.domain.Device;
import com.Malkov.domain.Event;
import com.Malkov.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImp implements Service{

    private final DaoImp daoImp = new DaoImp();


    @Override
    public void addProject(Project project) {
        daoImp.addProject(project);
    }

    @Override
    public void addDevice(Device device) {
        daoImp.addDevice(device);
    }

    @Override
    public void addEvent(Event event) {
        daoImp.addEvent(event);
    }

    @Override
    public void updateProject(Project project) {
        daoImp.updateProject(project);
    }

    @Override
    public void updateDevice(Device device) {
        daoImp.updateDevice(device);
    }

    @Override
    public void updateEvent(Event event) {
        daoImp.updateEvent(event);
    }

    @Override
    public Project getProjectById(int id) {
        return daoImp.getProjectById(id);
    }

    @Override
    public List<Project> listProject() {
        return daoImp.listProject();
    }

    @Override
    public Device getDeviceById(int id) {
        return daoImp.getDeviceById(id);
    }

    @Override
    public Event getEventById(int id) {
        return daoImp.getEventById(id);
    }

    @Override
    public List<Device> listDevice() {
        return daoImp.listDevice();
    }

    @Override
    public void removeProject(Project project) {
        daoImp.removeProject(project);
    }

    @Override
    public void removeEvent(Event event) {
        daoImp.removeEvent(event);
    }

    @Override
    public void removeDevice(Device device) {
        daoImp.removeDevice(device);
    }
}
