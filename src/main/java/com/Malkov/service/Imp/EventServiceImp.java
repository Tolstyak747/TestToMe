package com.Malkov.service.Imp;

import com.Malkov.dao.DaoImp;
import com.Malkov.domain.Event;
import com.Malkov.service.ServiceEvent;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImp implements ServiceEvent {

    DaoImp daoImp = new DaoImp();
    @Override
    public void add(Event event) {
        daoImp.addEvent(event);
    }

    @Override
    public void update(Event event) {
        daoImp.updateEvent(event);
    }

    @Override
    public Event getById(int id) {
        return daoImp.getEventById(id);
    }

    @Override
    public void remove(Event event) {
        daoImp.removeEvent(event);
    }
}
