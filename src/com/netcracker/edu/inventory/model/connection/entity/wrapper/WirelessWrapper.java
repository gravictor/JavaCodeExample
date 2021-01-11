package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.Wireless;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.List;

public class WirelessWrapper<A extends Device> extends ConnectionWrapper<A> implements Wireless<A,A> {

    public WirelessWrapper(AbstractConnectionWrapper<A> abstractConnectionWrapper) {
        super(abstractConnectionWrapper);
    }

    @Override
    public String getTechnology() {
        return abstractConnectionWrapper.getTechnology();
    }

    @Override
    public String getProtocol() {
        return abstractConnectionWrapper.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        abstractConnectionWrapper.setProtocol(protocol);
    }

    @Override
    public int getVersion() {
        return abstractConnectionWrapper.getVersion();
    }

    @Override
    public void setVersion(int version) {
        abstractConnectionWrapper.setVersion(version);
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
    public List<A> getBPoints() {
        return abstractConnectionWrapper.getBPoints();
    }

    @Override
    public void setBPoints(List<A> devices) {
        abstractConnectionWrapper.setBPoints(devices);
    }

    @Override
    public int getBCapacity() {
        return abstractConnectionWrapper.getBCapacity();
    }

    @Override
    public A getBPoint(int deviceNumber) {
        return abstractConnectionWrapper.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(A device, int deviceNumber) {
        abstractConnectionWrapper.setBPoint(device, deviceNumber);
    }

}
