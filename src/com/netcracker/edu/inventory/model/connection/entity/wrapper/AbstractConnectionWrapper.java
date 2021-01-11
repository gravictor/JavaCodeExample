package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.entity.*;
import com.netcracker.edu.inventory.model.connection.impl.ConnectionPK;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AbstractConnectionWrapper<A extends Device> implements AllConnections<A> {
    OpticFiber<A,A> opticFiber;
    ThinCoaxial<A> thinCoaxial;
    TwistedPair<A,A> twistedPair;
    Wireless<A,A> wireless;

    public AbstractConnectionWrapper(Connection<A,A> connection){
        if(connection instanceof OpticFiber) this.opticFiber = (OpticFiber<A,A>) connection;
        if(connection instanceof ThinCoaxial) this.thinCoaxial = (ThinCoaxial<A>) connection;
        if(connection instanceof TwistedPair) this.twistedPair = (TwistedPair<A,A>) connection;
        if(connection instanceof Wireless) this.wireless = (Wireless<A,A>) connection;
    }

    @Override
    public ConnectorType getConnectorType() {
        return thinCoaxial.getConnectorType();
    }

    @Override
    public boolean addDevice(A device) {
        return thinCoaxial.addDevice(device);
    }

    @Override
    public boolean removeDevice(A device) {
        return thinCoaxial.removeDevice(device);
    }

    @Override
    public boolean containDevice(A device) {
        return thinCoaxial.containDevice(device);
    }

    @Override
    public Set<A> getAllDevices() {
        return thinCoaxial.getAllDevices();
    }

    @Override
    public int getCurSize() {
        return thinCoaxial.getCurSize();
    }

    @Override
    public int getMaxSize() {
        return thinCoaxial.getMaxSize();
    }

    @Override
    public List<A> getBPoints() {
        return wireless.getBPoints();
    }

    @Override
    public void setBPoints(List<A> devices) {
        wireless.setBPoints(devices);
    }

    @Override
    public int getBCapacity() {
        return wireless.getBCapacity();
    }

    @Override
    public A getBPoint(int deviceNumber) {
        return wireless.getBPoint(deviceNumber);
    }

    @Override
    public void setBPoint(A device, int deviceNumber) {
        wireless.setBPoint(device, deviceNumber);
    }

    @Override
    public Mode getMode() {
        return opticFiber.getMode();
    }

    @Override
    public int getLength() {
        if(twistedPair != null) return twistedPair.getLength();
        else return opticFiber.getLength();
    }

    @Override
    public void setLength(int length) {
        if(twistedPair != null) twistedPair.setLength(length);
        else opticFiber.setLength(length);
    }

    @Override
    public Type getType() {
        return twistedPair.getType();
    }

    @Override
    public String getTechnology() {
        return wireless.getTechnology();
    }

    @Override
    public String getProtocol() {
        return wireless.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        wireless.setProtocol(protocol);
    }

    @Override
    public int getVersion() {
        return wireless.getVersion();
    }

    @Override
    public void setVersion(int version) {
        wireless.setVersion(version);
    }

    @Override
    public Trunk getTrunk() {
        if(opticFiber != null) return opticFiber.getTrunk();
        else if(thinCoaxial != null) return thinCoaxial.getTrunk();
        else if(twistedPair != null) return twistedPair.getTrunk();
        else return wireless.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        if(opticFiber != null) opticFiber.setTrunk(trunk);
        else if(thinCoaxial != null)  thinCoaxial.setTrunk(trunk);
        else if(twistedPair != null)  twistedPair.setTrunk(trunk);
        else  wireless.setTrunk(trunk);
    }

    @Override
    public int getSerialNumber() {
        if(opticFiber != null) return opticFiber.getSerialNumber();
        else if(thinCoaxial != null) return thinCoaxial.getSerialNumber();
        else if(twistedPair != null) return twistedPair.getSerialNumber();
        else return wireless.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        if(opticFiber != null) opticFiber.setSerialNumber(serialNumber);
        else if(thinCoaxial != null)  thinCoaxial.setSerialNumber(serialNumber);
        else if(twistedPair != null)  twistedPair.setSerialNumber(serialNumber);
        else  wireless.setSerialNumber(serialNumber);
    }

    @Override
    public String getStatus() {
        if(opticFiber != null) return opticFiber.getStatus();
        else if(thinCoaxial != null) return thinCoaxial.getStatus();
        else if(twistedPair != null) return twistedPair.getStatus();
        else return wireless.getStatus();
    }

    @Override
    public void setStatus(String status) {
        if(opticFiber != null) opticFiber.setStatus(status);
        else if(thinCoaxial != null)  thinCoaxial.setStatus(status);
        else if(twistedPair != null)  twistedPair.setStatus(status);
        else  wireless.setStatus(status);
    }

    @Override
    public A getAPoint() {
        if(opticFiber != null) return opticFiber.getAPoint();
        else if(twistedPair != null)  return twistedPair.getAPoint();
        else  return wireless.getAPoint();
    }

    @Override
    public void setAPoint(A device) {
        if(opticFiber != null)  opticFiber.setAPoint(device);
        else if(twistedPair != null)   twistedPair.setAPoint(device);
        else   wireless.setAPoint(device);
    }

    @Override
    public A getBPoint() {
        if(opticFiber != null) return opticFiber.getBPoint();
        else return twistedPair.getBPoint();
    }

    @Override
    public void setBPoint(A device) {
        if(opticFiber != null)  opticFiber.setBPoint(device);
        else  twistedPair.setBPoint(device);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) throws Exception {
        if(opticFiber != null) opticFiber.fillAllFields(fields);
        else if(thinCoaxial != null)  thinCoaxial.fillAllFields(fields);
        else if(twistedPair != null)  twistedPair.fillAllFields(fields);
        else  wireless.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        if(opticFiber != null) return opticFiber.getAllFields();
        else if(thinCoaxial != null) return thinCoaxial.getAllFields();
        else if(twistedPair != null) return twistedPair.getAllFields();
        else return wireless.getAllFields();
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        if(opticFiber != null) return opticFiber.getAPointConnectorType();
        else if(twistedPair != null)  return twistedPair.getAPointConnectorType();
        else  return wireless.getAPointConnectorType();
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        if(opticFiber != null) return opticFiber.getBPointConnectorType();
        else if(twistedPair != null)  return twistedPair.getBPointConnectorType();
        else  return wireless.getBPointConnectorType();
    }

    @Override
    public int compareTo(Connection o) {
        if(opticFiber != null) return opticFiber.compareTo(o);
        else if(thinCoaxial != null) return thinCoaxial.compareTo(o);
        else if(twistedPair != null) return twistedPair.compareTo(o);
        else return wireless.compareTo(o);
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public ConnectionPrimaryKey getPrimaryKey() {
        if(getTrunk() ==null || getSerialNumber() == 0)
            return null;
        return new ConnectionPK(getTrunk(), getSerialNumber());
    }
}
