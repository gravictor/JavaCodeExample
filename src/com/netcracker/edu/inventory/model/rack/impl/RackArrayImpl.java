package com.netcracker.edu.inventory.model.rack.impl;

import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.RackPrimaryKey;
import com.netcracker.edu.inventory.service.ServiceFactory;
import com.netcracker.edu.inventory.service.impl.ServiceFactoryImpl;
import com.netcracker.edu.location.Location;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RackArrayImpl<T extends Device> implements Rack<T> {
    T[] devices;
    int size;
    protected Location location;
    protected final Class type;
    private ServiceFactory service = new ServiceFactoryImpl();
    protected final static Logger log = Logger.getLogger(RackArrayImpl.class.getName());

    public RackArrayImpl(int size, Class clazz) {
        if (size > 0) {
            this.size = size;
        } else {
            this.devices = (T[]) new Device[0];
            IllegalArgumentException e = new IllegalArgumentException("Size of rack can not be 0 or less.");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
        if (clazz == null || !Device.class.isAssignableFrom(clazz)) {
            IllegalArgumentException e = new IllegalArgumentException("Type can't be null or not 'Device'");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
        this.devices = (T[]) new Device[size];
        this.type = clazz;
    }

    public RackArrayImpl(int size) {
        this(size, Device.class);
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getFreeSize() {
        int freeSize = 0;
        for (Device device : devices) {
            if (device == null)
                freeSize++;
        }
        return freeSize;
    }

    @Override
    public Class getTypeOfDevices() {
        return type;
    }

    @Override
    public T getDevAtSlot(int index) {
        if (indexCheck(index)) return null;
        else return devices[index];
    }

    @Override
    public boolean insertDevToSlot(T device, int index) {
        if (this.getFreeSize() == 0 || (indexCheck(index)))
            return false;
        if (!service.createDeviceServiceImpl().isValidDeviceForInsertToRack(device)) {
            DeviceValidationException e = new DeviceValidationException("Rack.InsertDevToSlot", device);
            log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        if (!(this.type.isAssignableFrom(device.getClass())))
            throw new IllegalArgumentException();
        if (devices[index] != null)
            return false;
        devices[index] = (T) device;
        return true;
    }

    @Override
    public T removeDevFromSlot(int index) {
        if (indexCheck(index)) {
            return null;
        }
        if (devices[index] == null) {
            log.warning("Can not remove from empty slot " + index);
            return null;
        }
        if ((index < size) && (index >= 0)) {
            Device device;
            if (devices[index] != null) {
                device = devices[index];
                devices[index] = null;
                return (T) device;
            } else
                return null;
        }
        return null;
    }

    @Override
    public T getDevByIN(int in) {
        for (Device device : devices) {
            if (device != null)
                if (device.getIn() == in)
                    return (T) device;
        }
        return null;
    }

    @Override
    public T[] getAllDeviceAsArray() {
        Device[] arr = new Device[devices.length - getFreeSize()];

        int j = 0;
        while (j < arr.length)
            for (int i = 0; i < devices.length; i++)
                if (devices[i] != null) {
                    arr[j] = devices[i];
                    j++;
                }
        return (T[]) arr;
    }

    private boolean indexCheck(int index) {
        if ((index >= this.size) || (index < 0)) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException(index + " is out of bounds");
            log.log(Level.SEVERE, e.toString(), e);
            throw e;
        }
        return false;
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public RackPrimaryKey getPrimaryKey() {
        if(location ==null)
            return null;
        return new RackPK(location);
    }
}