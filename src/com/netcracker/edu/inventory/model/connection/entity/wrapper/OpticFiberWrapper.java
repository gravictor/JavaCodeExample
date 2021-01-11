package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.OpticFiber;
import com.netcracker.edu.inventory.model.device.Device;

public class OpticFiberWrapper<A extends Device> extends ConnectionWrapper<A> implements OpticFiber<A, A> {

    public OpticFiberWrapper(AbstractConnectionWrapper<A> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }

    @Override
    public Mode getMode() {
        return abstractConnectionWrapper.getMode();
    }

    @Override
    public int getLength() {
        return abstractConnectionWrapper.getLength();
    }

    @Override
    public void setLength(int length) {
        abstractConnectionWrapper.setLength(length);
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return abstractConnectionWrapper.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return abstractConnectionWrapper.getBPointConnectorType();
    }

    @Override
    public A getAPoint() {
        return abstractConnectionWrapper.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        abstractConnectionWrapper.setAPoint(device);
    }

    @Override
    public A getBPoint() {
        return abstractConnectionWrapper.getBPoint();
    }

    @Override
    public void setBPoint(A device) {
        abstractConnectionWrapper.setBPoint(device);
    }
}
