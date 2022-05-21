package com.Malkov.service;

import com.Malkov.domain.Device;

import java.util.List;

public interface ServiceDevice {
    void add(Device device);
    void update(Device device);
    Device getById(int id);
    void remove(Device device);

    List<Device> listDevices();
}
