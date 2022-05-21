package com.Malkov.service;

import com.Malkov.domain.Project;

public interface ServiceProj {
    void add(Project project);
    void update(Project project);
    Project getById(int id);
    void remove(Project project);
    String listProjeсts();
    String getDevices(int id);
}
