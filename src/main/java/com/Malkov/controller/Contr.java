package com.Malkov.controller;

import com.Malkov.domain.Device;
import com.Malkov.domain.Project;
import com.Malkov.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Contr {
    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String listProject(){
        List<Project> projects = service.listProject();
        StringBuilder infoLs = new StringBuilder();
        for (Project p:projects
             ) {
            infoLs.append(p.toString());
        }
        return infoLs.toString();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getProject(@PathVariable(name = "id") int id){
        Project project = service.getProjectById(id);
        List<Device> devices = project.getDevices();
        StringBuilder infoDev = new StringBuilder();
        for (Device d:devices
             ) {
            infoDev.append(d.toString());
        }
        return infoDev.toString();
    }

}
