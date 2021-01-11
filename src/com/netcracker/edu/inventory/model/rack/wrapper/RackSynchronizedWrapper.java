package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.location.Location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RackSynchronizedWrapper extends AbstractRackWrapper {
    public RackSynchronizedWrapper(Rack rack) {
        super(rack);
    }

    @Override
    synchronized public Class getTypeOfDevices() {
        return super.getTypeOfDevices();
    }

    @Override
    synchronized public Location getLocation() {
        return super.getLocation();
    }

    @Override
    synchronized public int getSize() {
        return super.getSize();
    }

    @Override
    synchronized public int getFreeSize() {
        return super.getFreeSize();
    }

    @Override
    synchronized public Device getDevAtSlot(int index) {
        return super.getDevAtSlot(index);
    }

    @Override
    synchronized public Device getDevByIN(int in) {
        return super.getDevByIN(in);
    }

    @Override
    synchronized public Device[] getAllDeviceAsArray() {
        return super.getAllDeviceAsArray();
    }

    @Override
    synchronized public Rack subscribe(PropertyChangeListener listener) {
        return super.subscribe(listener);
    }

    @Override
    synchronized public boolean unSubscribe(PropertyChangeListener listener) {
        return super.unSubscribe(listener);
    }

    @Override
    synchronized public void setLocation(Location location) {
        super.setLocation(location);
    }

    @Override
    synchronized public boolean insertDevToSlot(Device device, int index) {
        return super.insertDevToSlot(device, index);
    }

    @Override
    synchronized public Device removeDevFromSlot(int index) {
        return super.removeDevFromSlot(index);
    }
}
