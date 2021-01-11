package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.Set;

public class ThinCoaxialWrapper<A extends Device> extends ConnectionWrapper<A> implements ThinCoaxial<A> {

    public ThinCoaxialWrapper(AbstractConnectionWrapper<A> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }

    @Override
    public ConnectorType getConnectorType() {
        return abstractConnectionWrapper.getConnectorType();
    }

    @Override
    public boolean addDevice(A device) {
        return abstractConnectionWrapper.addDevice(device);
    }

    @Override
    public boolean removeDevice(A device) {
        return abstractConnectionWrapper.removeDevice(device);
    }

    @Override
    public boolean containDevice(A device) {
        return abstractConnectionWrapper.containDevice(device);
    }

    @Override
    public Set<A> getAllDevices() {
        return abstractConnectionWrapper.getAllDevices();
    }

    @Override
    public int getCurSize() {
        return abstractConnectionWrapper.getCurSize();
    }

    @Override
    public int getMaxSize() {
        return abstractConnectionWrapper.getMaxSize();
    }
}
