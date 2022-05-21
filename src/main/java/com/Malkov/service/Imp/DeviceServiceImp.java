package com.Malkov.service.Imp;

import com.Malkov.dao.DaoImp;
import com.Malkov.domain.Device;
import com.Malkov.service.ServiceDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImp implements ServiceDevice {

    DaoImp daoImp = new DaoImp();

    @Override
    public void add(Device device) {
        daoImp.addDevice(device);
    }

    @Override
    public void update(Device device) {
        daoImp.updateDevice(device);
    }

    @Override
    public Device getById(int id) {
        return daoImp.getDeviceById(id);
    }

    @Override
    public void remove(Device device) {
        daoImp.removeDevice(device);
    }

    @Override
    public List<Device> listDevices() {
        return daoImp.listDevice();
    }
}
