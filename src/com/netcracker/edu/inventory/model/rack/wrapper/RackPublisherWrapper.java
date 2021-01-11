package com.netcracker.edu.inventory.model.rack.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.location.Location;

import java.beans.PropertyChangeEvent;

public class RackPublisherWrapper extends AbstractRackWrapper {
    public RackPublisherWrapper(Rack rack) {
        super(rack);
    }

    @Override
    public void setLocation(Location location) {
        propertyChange(new PropertyChangeEvent(rack, "location", rack.getLocation(), location));
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {
        propertyChange(new PropertyChangeEvent(rack, "devices", rack.getDevAtSlot(index), device));
        return rack.insertDevToSlot(device, index);
    }

    @Override
    public Device removeDevFromSlot(int index) {
        propertyChange(new PropertyChangeEvent(rack, "devices", rack.getDevAtSlot(index), null));
        return rack.removeDevFromSlot(index);
    }
}
