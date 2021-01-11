package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.connection.OneToManyConnection;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractOneToManyConnection<A extends Device, B extends Device> extends AbstractConnection implements OneToManyConnection {
    protected A        aPointConnector;
    protected Device[] bPointConnectors = new Device[0];
    protected int      maxSize;
    protected String   technology;
    protected String   protocol;
    protected int      version;
    private final static Logger log = Logger.getLogger(AbstractOneToManyConnection.class.getName());

    public AbstractOneToManyConnection() {
    }

    public AbstractOneToManyConnection(int maxSize, String technology) {
        if (maxSize < 0) {
            this.maxSize = 0;
        } else this.maxSize = maxSize;
        bPointConnectors = new Device[this.maxSize];
        this.technology = technology;
    }

    public AbstractOneToManyConnection(int maxSize) {
        if (maxSize < 0) {
            this.maxSize = 0;
        } else this.maxSize = maxSize;
        bPointConnectors = new Device[this.maxSize];
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return ConnectorType.Wireless;
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return ConnectorType.Wireless;
    }

    @Override
    public A getAPoint() {
        return aPointConnector;
    }

    @Override
    public void setAPoint(Device device) {
        this.aPointConnector = (A) device;
    }

    @Override
    public List getBPoints() {
        return Arrays.asList(bPointConnectors);
    }

    @Override
    public void setBPoints(List devices) {
        bPointConnectors = (Device[]) devices.toArray();
    }

    @Override
    public int getBCapacity() {
        return bPointConnectors.length;
    }

    @Override
    public B getBPoint(int deviceNumber) {
        if (checkDeviceNumber(deviceNumber))
            return (B) bPointConnectors[deviceNumber];
        return null;
    }

    @Override
    public void setBPoint(Device device, int deviceNumber) {
        if (checkDeviceNumber(deviceNumber)) bPointConnectors[deviceNumber] = device;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTechnology() {
        return technology;
    }

    private boolean checkDeviceNumber(int deviceNumber) {
        if( deviceNumber >= 0 && deviceNumber <= maxSize - 1)
            return true;
        IndexOutOfBoundsException e = new IndexOutOfBoundsException("index is out of bounds");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    @Override
    public void fillAllFields(Queue queue) {
        super.fillAllFields(queue);
        setAPoint((Device) super.getNext(queue));
        setBPoints(Arrays.asList((Device[]) super.getNext(queue)));
        maxSize = (Integer) super.getNext(queue);
        if(technology == null) {
            technology = (String) super.getNext(queue);
        }
        setProtocol((String) super.getNext(queue));
        setVersion((Integer) super.getNext(queue));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> queue = new ArrayDeque<>();
        queue.addAll(super.getAllFields());
        queue.add(new Field(Device.class, aPointConnector));
        queue.add(new Field(Device[].class, Arrays.copyOf(bPointConnectors, bPointConnectors.length)));
        queue.add(new Field(Integer.class, maxSize));
        queue.add(new Field(String.class, technology));
        queue.add(new Field(String.class, protocol));
        queue.add(new Field(Integer.class, version));
        return queue;
    }
}