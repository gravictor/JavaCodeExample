package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.location.Location;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RackImmutableWrapper<D extends Device> extends AbstractRackWrapper {

    private static final Logger log = Logger.getLogger(RackImmutableWrapper.class.getName());
    public RackImmutableWrapper(Rack rack) {
        super(rack);
    }

    @Override
    public void setLocation(Location location) {
        log.log(Level.WARNING, "Object is immutable");
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {
        log.log(Level.WARNING, "Object is immutable");
        return false;
    }

    @Override
    public D removeDevFromSlot(int index) {
        log.log(Level.WARNING, "Object is immutable");
        return null;
    }
}
