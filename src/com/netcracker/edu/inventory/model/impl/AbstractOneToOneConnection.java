package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.connection.OneToOneConnection;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class AbstractOneToOneConnection<A extends Device, B extends Device> extends AbstractConnection implements OneToOneConnection {
    protected A             aPointConnector;
    protected B             bPointConnector;
    protected ConnectorType aConnectorType;
    protected ConnectorType bConnectorType;
    protected int           length;

    public AbstractOneToOneConnection(ConnectorType connectorType) {
        super(connectorType);
        aConnectorType = connectorType;
        bConnectorType = connectorType;
    }

    public AbstractOneToOneConnection(int length, ConnectorType connectorType) {
        this(connectorType);
        if (length < 0) {
            this.length = 0;
        } else this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public ConnectorType getAPointConnectorType() {
        return aConnectorType;
    }

    @Override
    public ConnectorType getBPointConnectorType() {
        return bConnectorType;
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
    public B getBPoint() {
        return this.bPointConnector;
    }

    @Override
    public void setBPoint(Device device) {
        this.bPointConnector = (B) device;
    }

    @Override
    public void fillAllFields(Queue queue) {
        super.fillAllFields(queue);
        setAPoint((A) super.getNext(queue));
        bPointConnector = (B) super.getNext(queue);
        aConnectorType = ConnectorType.valueOf((String) super.getNext(queue));
        bConnectorType = ConnectorType.valueOf((String) super.getNext(queue));
        setLength((Integer) super.getNext(queue));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> queue = new ArrayDeque<>();
        queue.addAll(super.getAllFields());
        queue.add(new Field(Device.class, aPointConnector));
        queue.add(new Field(Device.class, bPointConnector));
        queue.add(new Field(String.class, aConnectorType.name()));
        queue.add(new Field(String.class, bConnectorType.name()));
        queue.add(new Field(Integer.class, length));
        return queue;
    }
}
