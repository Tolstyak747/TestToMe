package com.Malkov.service.Imp;

import com.Malkov.dao.DaoImp;
import com.Malkov.domain.Device;
import com.Malkov.domain.Project;
import com.Malkov.service.ServiceProj;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImp implements ServiceProj {

    DaoImp daoImp = new DaoImp();

    @Override
    public void add(Project project) {
        daoImp.addProject(project);
    }

    @Override
    public void update(Project project) {
        daoImp.updateProject(project);
    }

    @Override
    public Project getById(int id) {
        return daoImp.getProjectById(id);
    }

    @Override
    public void remove(Project project) {
        daoImp.removeProject(project);
    }

    @Override
    public String listProjeсts() {
        List<Project> prjs = daoImp.listProject();
        StringBuilder lsPr = new StringBuilder();
        for (Project p:prjs
             ) {
            lsPr.append(p.toString());
        }
        return lsPr.toString();
    }

    @Override
    public String getDevices(int id) {
        Project project = daoImp.getProjectById(id);
        List<Device> devices = project.getDevices();
        StringBuilder sb = new StringBuilder();
        for (Device d:devices
             ) {
            sb.append(d);
        }
        return sb.toString();
    }
}
