package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionsImmutableWrapper<A extends Device> extends AbstractConnectionWrapper<A> {
    Logger logger = Logger.getLogger(AbstractConnectionWrapper.class.getName());

    public ConnectionsImmutableWrapper(Connection connection) {
        super(connection);
    }
    @Override
    public boolean addDevice(A device) {
        writeInLog();
        return false;
    }

    @Override
    public boolean removeDevice(A device) {
        writeInLog();
        return false;
    }

    @Override
    public void setBPoints(List<A> devices) {
        writeInLog();
    }

    @Override
    public void setBPoint(A device, int deviceNumber) {
        writeInLog();
    }

    @Override
    public void setLength(int length) {
        writeInLog();
    }

    @Override
    public void setProtocol(String protocol) {
        writeInLog();
    }

    @Override
    public void setVersion(int version) {
        writeInLog();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        writeInLog();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        writeInLog();
    }

    @Override
    public void setStatus(String status) {
        writeInLog();;
    }

    @Override
    public void setAPoint(A device) {
        writeInLog();
    }

    @Override
    public void setBPoint(A device) {
        writeInLog();
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        writeInLog();
    }

    private void writeInLog(){
        logger.log(Level.WARNING, "Object is immutable");
    }
}
