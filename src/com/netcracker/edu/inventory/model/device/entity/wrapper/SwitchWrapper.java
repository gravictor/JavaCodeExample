package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.entity.Switch;

import java.util.List;

public class SwitchWrapper extends DeviceWrapper implements Switch {
    public SwitchWrapper(AbstractDeviceWrapper abstractDeviceWrapper) {
        super(abstractDeviceWrapper);
    }

    @Override
    public int getNumberOfPorts() {
        return abstractDeviceWrapper.getNumberOfPorts();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        abstractDeviceWrapper.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public ConnectorType getPortsType() {
        return abstractDeviceWrapper.getPortsType();
    }

    @Override
    public Connection getPortConnection(int portNumber) {
        return abstractDeviceWrapper.getPortConnection(portNumber);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        abstractDeviceWrapper.setPortConnection(connection, portNumber);
    }

    @Override
    public List<Connection> getAllPortConnections() {
        return abstractDeviceWrapper.getAllPortConnections();
    }

    @Override
    public int getDataRate() {
        return abstractDeviceWrapper.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        abstractDeviceWrapper.setDataRate(dataRate);
    }
}
