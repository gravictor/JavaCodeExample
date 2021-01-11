package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.RackPrimaryKey;
import com.netcracker.edu.location.Location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class AbstractRackWrapper<D extends Device> implements Rack<D>, PropertyChangeListener {

    List<PropertyChangeListener> listeners = new ArrayList<>();
    AbstractRackWrapper abstractRackWrapper;
    Rack<D> rack;

    public AbstractRackWrapper(Rack<D> rack){
        if(rack instanceof PropertyChangeListener){
            abstractRackWrapper=(AbstractRackWrapper) rack;
            listeners = abstractRackWrapper.listeners;
        }
        this.rack = rack;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        for(PropertyChangeListener listener: listeners){
            listener.propertyChange(evt);
        }
    }

    @Override
    public Class getTypeOfDevices() {
        return rack.getTypeOfDevices();
    }

    @Override
    public Location getLocation() {
        return rack.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        rack.setLocation(location);
    }

    @Override
    public int getSize() {
        return rack.getSize();
    }

    @Override
    public int getFreeSize() {
        return rack.getFreeSize();
    }

    @Override
    public D getDevAtSlot(int index) {
        return rack.getDevAtSlot(index);
    }

    @Override
    public boolean insertDevToSlot(D device, int index) {
        return false;
    }

    @Override
    public D removeDevFromSlot(int index) {
        return null;
    }

    @Override
    public D getDevByIN(int in) {
        return rack.getDevByIN(in);
    }

    @Override
    public D[] getAllDeviceAsArray() {
        return rack.getAllDeviceAsArray();
    }


    public Rack subscribe(PropertyChangeListener listener){
        listeners.add(listener);
        return this;
    }

    public boolean unSubscribe(PropertyChangeListener listener){
        return listeners.remove(listener);
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public RackPrimaryKey getPrimaryKey() {
        return null;
    }
}
