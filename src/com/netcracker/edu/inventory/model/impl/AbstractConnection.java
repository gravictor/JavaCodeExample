package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.connection.impl.ConnectionPK;
import com.netcracker.edu.inventory.model.connection.impl.DummyConnection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractConnection<A extends Device, B extends Device> implements Connection<A, B> {
    private static final Logger log = Logger.getLogger(AbstractConnection.class.getName());
    protected RuntimeException exception;
    protected Trunk trunk;
    protected int serialNumber;
    protected String status = "Planed";
    protected ConnectorType connectorType = ConnectorType.need_init;

    public AbstractConnection() {
        connectorType = ConnectorType.need_init;

    }

    public AbstractConnection(ConnectorType connectorType) {
        this();
        this.connectorType = connectorType;
    }

    public ConnectorType getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(ConnectorType connectorType) {
        this.connectorType = connectorType;
    }

    @Override
    public boolean isLazy() {
        if (this instanceof DummyConnection) return true;
        return false;
    }

    @Override
    public ConnectionPrimaryKey getPrimaryKey() {
        if(serialNumber ==0 || trunk ==null)
            return null;
        return new ConnectionPK(trunk, serialNumber);
    }

    @Override
    public Trunk getTrunk() {
        return trunk;
    }

    @Override
    public void setTrunk(Trunk trunk) {
        if (trunk != null) this.trunk = trunk;
    }

    @Override
    public int getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        if (serialNumber < 0) {
            exception = new IllegalArgumentException("IN can not be negative.(" + serialNumber + ")");
            log.log(Level.SEVERE, exception.getMessage(), exception);
            throw exception;
        } else if (this.serialNumber == 0) {
            this.serialNumber = serialNumber;
        } else {
            log.log(Level.WARNING, "Inventory number can not be reset.");
        }
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        setSerialNumber((Integer) getNext(fields));
        setStatus((String) getNext(fields));
        setTrunk((Trunk) getNext(fields));
        setConnectorType(ConnectorType.valueOf((String) getNext(fields)));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> queue = new ArrayDeque<>();
        queue.add(new Field(Integer.class, this.serialNumber));
        queue.add(new Field(String.class, this.status));
        queue.add(new Field(Trunk.class, this.trunk));
        queue.add(new Field(String.class, connectorType.name()));
        return queue;
    }

    @Override
    public int compareTo(Connection o) {
        if (o == null)
            return -1;
        return Integer.compare(this.serialNumber, o.getSerialNumber());
    }

    protected Object getNext(Queue<Field> fields) {
        if(fields.peek() == null){
            NoSuchElementException exception = new NoSuchElementException("The queue is empty");
            log.log(Level.SEVERE, exception.getMessage(),exception);
            throw exception;
        }
        return fields.poll().getValue();
    }
}
