package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.AllToAllConnection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.*;

public abstract class AbstractAllToAllConnection<T extends Device> extends AbstractConnection implements AllToAllConnection {
    protected Set<T> devices = new HashSet<>();
    protected int maxSize;

    public AbstractAllToAllConnection() {
        this(ConnectorType.TConnector);
    }

    public AbstractAllToAllConnection(ConnectorType connectorType) {
        if (connectorType == null) setConnectorType(ConnectorType.need_init);
        else setConnectorType(ConnectorType.TConnector);
    }

    public AbstractAllToAllConnection(int maxSize) {
        this(ConnectorType.TConnector);
        if (maxSize < 0) {
            this.maxSize = 0;
        } else this.maxSize = maxSize;
        devices = new HashSet<>(maxSize);
    }

    @Override
    public boolean addDevice(Device device) {
        if(!device.isLazy())
            return devices.add((T) device);
        return false;
    }

    @Override
    public boolean removeDevice(Device device) {
        return devices.remove((T) device);
    }

    @Override
    public boolean containDevice(Device device) {
        return devices.contains((T) device);
    }

    @Override
    public Set getAllDevices() {
        return new HashSet(devices);
    }

    @Override
    public int getCurSize() {
        return devices.size();
    }

    @Override
    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public void fillAllFields(Queue queue) {
        super.fillAllFields(queue);
        devices = (Set<T>) super.getNext(queue);
        maxSize = (Integer) super.getNext(queue);
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> queue = new ArrayDeque<>();
        queue.addAll(super.getAllFields());
        queue.add(new Field(Set.class, devices));
        queue.add(new Field(Integer.class, maxSize));
        return queue;
    }
}
