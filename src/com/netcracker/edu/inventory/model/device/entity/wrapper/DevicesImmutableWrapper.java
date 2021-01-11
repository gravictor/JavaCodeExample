package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.Date;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DevicesImmutableWrapper extends AbstractDeviceWrapper {

    Logger log = Logger.getLogger(AbstractDeviceWrapper.class.getName());

    public DevicesImmutableWrapper(Device wrapper) {
        super(wrapper);
    }


    @Override
    public void setIn(int in) {
        writeInLog();
    }

    @Override
    public void setType(String type) {
        writeInLog();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        writeInLog();
    }

    @Override
    public void setModel(String model) {
        writeInLog();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        writeInLog();
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {
        writeInLog();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        writeInLog();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        writeInLog();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        writeInLog();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        writeInLog();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        writeInLog();
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        writeInLog();
    }


    @Override
    public void setDataRate(int dataRate) {
        writeInLog();
    }

    private void writeInLog() {
        log.log(Level.WARNING, "Object is immutable");
    }
}
