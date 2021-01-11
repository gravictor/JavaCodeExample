package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ConnectionsPublisherWrapper<A extends Device> extends AbstractConnectionWrapper<A> implements PropertyChangeListener {

    protected List<PropertyChangeListener> listeners = new ArrayList<>();
    ConnectionsPublisherWrapper connectionsPublisherWrapper;


    public ConnectionsPublisherWrapper(Connection<A, A> connection) {
        super(connection);
        if(connection instanceof ConnectionWrapper) {
            ConnectionWrapper connectionWrapper = (ConnectionWrapper) connection;
            if(connectionWrapper.getAbstractConnectionWrapper() instanceof ConnectionsPublisherWrapper) {
                connectionsPublisherWrapper = (ConnectionsPublisherWrapper) connectionWrapper.getAbstractConnectionWrapper();
                listeners = connectionsPublisherWrapper.listeners;
            }
        }
    }

    @Override
    public void setTrunk(Trunk trunk) {
        propertyChange(new PropertyChangeEvent(this, "trunk", this.getTrunk(), trunk));
        super.setTrunk(trunk);
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        propertyChange(new PropertyChangeEvent(this, "serialNumber", this.getSerialNumber(), serialNumber));
        super.setSerialNumber(serialNumber);
    }

    @Override
    public void setStatus(String status) {
        propertyChange(new PropertyChangeEvent(this, "status", this.getStatus(), status));
        super.setStatus(status);
    }

    @Override
    public void setLength(int length) {
        propertyChange(new PropertyChangeEvent(this, "length", this.getLength(), length));
        super.setLength(length);
    }

    @Override
    public void setBPoint(A device) {
        propertyChange(new PropertyChangeEvent(this, "bPoint", this.getBPoint(), device));
        super.setBPoint(device);
    }

    @Override
    public boolean addDevice(A device) {
        propertyChange(new PropertyChangeEvent(this, "devices", null, device));
        return super.addDevice(device);
    }

    @Override
    public boolean removeDevice(A device) {
        propertyChange(new PropertyChangeEvent(this, "devices", device, null));
        return thinCoaxial.removeDevice(device);
    }

    @Override
    public void setAPoint(A device) {
        propertyChange(new PropertyChangeEvent(this, "aPoint", this.getAPoint(), device));
        super.setAPoint(device);
    }

    @Override
    public void setProtocol(String protocol) {
        propertyChange(new PropertyChangeEvent(this, "protocol", this.getProtocol(), protocol));
        super.setProtocol(protocol);
    }

    @Override
    public void setVersion(int version) {
        propertyChange(new PropertyChangeEvent(this, "version", this.getVersion(), version));
        super.setVersion(version);
    }

    @Override
    public void setBPoints(List<A> devices) {
        propertyChange(new PropertyChangeEvent(this, "bPoints", this.getBPoints(), devices));
        super.setBPoints(devices);
    }

    @Override
    public void setBPoint(A device, int deviceNumber) {
        propertyChange(new PropertyChangeEvent(this, "bPoints", this.getBPoint(deviceNumber), device));
        super.setBPoint(device, deviceNumber);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        for (PropertyChangeListener listener:listeners) {
            listener.propertyChange(evt);
        }
    }

    public void subscribe(PropertyChangeListener listener){
        listeners.add(listener);
    }

    public boolean unsubscribe(PropertyChangeListener listener){
        return listeners.remove(listener);
    }
}
