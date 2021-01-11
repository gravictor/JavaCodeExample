package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ConnectionsSynchronizedWrapper<A extends Device> extends AbstractConnectionWrapper<A>{

    public ConnectionsSynchronizedWrapper(Connection<A, A> connection) {
        super(connection);
    }

    @Override
    synchronized public ConnectorType getConnectorType() {
        return super.getConnectorType();
    }

    @Override
    synchronized public boolean addDevice(A device) {
        return super.addDevice(device);
    }

    @Override
    synchronized public boolean removeDevice(A device) {
        return super.removeDevice(device);
    }

    @Override
    synchronized public boolean containDevice(A device) {
        return super.containDevice(device);
    }

    @Override
    synchronized public Set<A> getAllDevices() {
        return super.getAllDevices();
    }

    @Override
    synchronized public int getCurSize() {
        return super.getCurSize();
    }

    @Override
    synchronized public int getMaxSize() {
        return super.getMaxSize();
    }

    @Override
    synchronized public List<A> getBPoints() {
        return super.getBPoints();
    }

    @Override
    synchronized public void setBPoints(List<A> devices) {
        super.setBPoints(devices);
    }

    @Override
    synchronized public int getBCapacity() {
        return super.getBCapacity();
    }

    @Override
    synchronized public A getBPoint(int deviceNumber) {
        return super.getBPoint(deviceNumber);
    }

    @Override
    synchronized public void setBPoint(A device, int deviceNumber) {
        super.setBPoint(device, deviceNumber);
    }

    @Override
    synchronized public Mode getMode() {
        return super.getMode();
    }

    @Override
    synchronized public int getLength() {
        return super.getLength();
    }

    @Override
    synchronized public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    synchronized public Type getType() {
        return super.getType();
    }

    @Override
    synchronized public String getTechnology() {
        return super.getTechnology();
    }

    @Override
    synchronized public String getProtocol() {
        return super.getProtocol();
    }

    @Override
    synchronized public void setProtocol(String protocol) {
        super.setProtocol(protocol);
    }

    @Override
    synchronized public int getVersion() {
        return super.getVersion();
    }

    @Override
    synchronized public void setVersion(int version) {
        super.setVersion(version);
    }

    @Override
    synchronized public Trunk getTrunk() {
        return super.getTrunk();
    }

    @Override
    synchronized public void setTrunk(Trunk trunk) {
        super.setTrunk(trunk);
    }

    @Override
    synchronized public int getSerialNumber() {
        return super.getSerialNumber();
    }

    @Override
    synchronized public void setSerialNumber(int serialNumber) {
        super.setSerialNumber(serialNumber);
    }

    @Override
    synchronized public String getStatus() {
        return super.getStatus();
    }

    @Override
    synchronized public void setStatus(String status) {
        super.setStatus(status);
    }

    @Override
    synchronized public A getAPoint() {
        return super.getAPoint();
    }

    @Override
    synchronized public void setAPoint(A device) {
        super.setAPoint(device);
    }

    @Override
    synchronized public A getBPoint() {
        return super.getBPoint();
    }

    @Override
    synchronized public void setBPoint(A device) {
        super.setBPoint(device);
    }

    @Override
    synchronized public void fillAllFields(Queue<Field> fields) throws Exception {
        super.fillAllFields(fields);
    }

    @Override
    synchronized public Queue<Field> getAllFields() {
        return super.getAllFields();
    }

    @Override
    synchronized public ConnectorType getAPointConnectorType() {
        return super.getAPointConnectorType();
    }

    @Override
    synchronized public ConnectorType getBPointConnectorType() {
        return super.getBPointConnectorType();
    }

    @Override
    synchronized public int compareTo(Connection o) {
        return super.compareTo(o);
    }
}
