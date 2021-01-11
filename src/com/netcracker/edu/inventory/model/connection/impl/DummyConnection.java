package com.netcracker.edu.inventory.model.connection.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.impl.AbstractConnection;
import com.netcracker.edu.location.Trunk;

import java.util.Objects;
import java.util.Queue;
import java.util.logging.Logger;

public class DummyConnection extends AbstractConnection implements Connection {

    Logger log = Logger.getLogger(DummyConnection.class.getName());
    ConnectionPrimaryKey connectionPrimaryKey;

    public DummyConnection(ConnectionPrimaryKey connectionPK) {
        connectionPrimaryKey = connectionPK;
    }

    @Override
    public Trunk getTrunk() {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public void setTrunk(Trunk trunk) {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public int getSerialNumber() {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public String getStatus() {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public void setStatus(String status) {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public void fillAllFields(Queue queue) {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public Queue<Field> getAllFields() {
        throw new UnsupportedOperationException("Connection is dummy");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DummyConnection that = (DummyConnection) o;
        return Objects.equals(log, that.log) &&
                Objects.equals(connectionPrimaryKey, that.connectionPrimaryKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(log, connectionPrimaryKey);
    }

    @Override
    public ConnectionPrimaryKey getPrimaryKey() {
        return connectionPrimaryKey;
    }

    @Override
    public int compareTo(Connection o) {
        if (o instanceof DummyConnection)
            return Integer.compare(connectionPrimaryKey.getSerialNumber(), ((DummyConnection) o).getPrimaryKey().getSerialNumber());
        return -1;
    }
}
