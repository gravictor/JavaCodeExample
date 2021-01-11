package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;

import java.util.Date;
import java.util.List;
import java.util.Queue;

public class DevicesSynchronizedWrapper extends AbstractDeviceWrapper{
    public DevicesSynchronizedWrapper(Device device) {
        super(device);
    }

    @Override
    synchronized public int getIn() {
        return super.getIn();
    }

    @Override
    synchronized public void setIn(int in) {
        super.setIn(in);
    }

    @Override
    synchronized public String getType() {
        return super.getType();
    }

    @Override
    synchronized public void setType(String type) {
        super.setType(type);
    }

    @Override
    synchronized public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    synchronized public void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
    }

    @Override
    synchronized public String getModel() {
        return super.getModel();
    }

    @Override
    synchronized public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    synchronized public Date getProductionDate() {
        return super.getProductionDate();
    }

    @Override
    synchronized public void setProductionDate(Date productionDate) {
        super.setProductionDate(productionDate);
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
    synchronized public int compareTo(Device o) {
        return super.compareTo(o);
    }

    @Override
    synchronized public int getChargeVolume() {
        return super.getChargeVolume();
    }

    @Override
    synchronized public void setChargeVolume(int chargeVolume) {
        super.setChargeVolume(chargeVolume);
    }

    @Override
    synchronized public int getNumberOfPorts() {
        return super.getNumberOfPorts();
    }

    @Override
    synchronized public void setNumberOfPorts(int numberOfPorts) {
        super.setNumberOfPorts(numberOfPorts);
    }

    @Override
    synchronized public ConnectorType getPortsType() {
        return super.getPortsType();
    }

    @Override
    synchronized public Connection getPortConnection(int portNumber) {
        return super.getPortConnection(portNumber);
    }

    @Override
    synchronized public void setPortConnection(Connection connection, int portNumber) {
        super.setPortConnection(connection, portNumber);
    }

    @Override
    synchronized public List<Connection> getAllPortConnections() {
        return super.getAllPortConnections();
    }

    @Override
    synchronized public int getDataRate() {
        return super.getDataRate();
    }

    @Override
    synchronized public void setDataRate(int dataRate) {
        super.setDataRate(dataRate);
    }

    @Override
    synchronized public String getTechnologyVersion() {
        return super.getTechnologyVersion();
    }

    @Override
    synchronized public String getSecurityProtocol() {
        return super.getSecurityProtocol();
    }

    @Override
    synchronized public void setSecurityProtocol(String securityProtocol) {
        super.setSecurityProtocol(securityProtocol);
    }

    @Override
    synchronized public Connection getWirelessConnection() {
        return super.getWirelessConnection();
    }

    @Override
    synchronized public void setWirelessConnection(Connection wirelessConnection) {
        super.setWirelessConnection(wirelessConnection);
    }

    @Override
    synchronized public ConnectorType getWirePortType() {
        return super.getWirePortType();
    }

    @Override
    synchronized public Connection getWireConnection() {
        return super.getWireConnection();
    }

    @Override
    synchronized public void setWireConnection(Connection wireConnection) {
        super.setWireConnection(wireConnection);
    }
}
