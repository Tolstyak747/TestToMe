package com.Malkov.controller;

import com.Malkov.service.ServiceProj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    private ServiceProj serviceProj;


    @Autowired
    public void setServiceProj(ServiceProj serviceProj) {
        this.serviceProj = serviceProj;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String listProjects() {
        return serviceProj.listProjeсts();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDevices(@PathVariable(name = "id") int id) {
        return serviceProj.getDevices(id);
    }

}
