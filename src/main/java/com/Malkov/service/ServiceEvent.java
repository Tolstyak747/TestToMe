package com.Malkov.service;

import com.Malkov.domain.Event;
import com.Malkov.domain.Project;

public interface ServiceEvent {
    void add(Event event);
    void update(Event event);
    Event getById(int id);
    void remove(Event event);
}
