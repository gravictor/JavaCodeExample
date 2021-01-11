package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Switch extends Router implements com.netcracker.edu.inventory.model.device.entity.Switch {

    protected static final Logger log = Logger.getLogger(Switch.class.getName());
    protected int numberOfPorts;
    private ConnectorType portsType = ConnectorType.need_init;
    private Connection[] portsConnections;

    public Switch() {
        portsConnections = new Connection[0];
    }

    public Switch(ConnectorType connectorType) {
        if (connectorType != null) this.portsType = connectorType;
    }

    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
        portsConnections = new Connection[numberOfPorts];
    }

    public ConnectorType getPortsType(){
        return this.portsType;
    }

    public void setPortConnection(Connection connection, int portNumber) {
        if (checkPort(portNumber)) {
            portsConnections[portNumber] = connection;
        }
    }

    public List<Connection> getAllPortConnections() {
        return Arrays.asList(portsConnections);
    }

    public Connection getPortConnection(int portNumber) {
        if (checkPort(portNumber)) {
            return portsConnections[portNumber];
        }
        return null;
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> temp = new ArrayDeque<>();
        temp.addAll(super.getAllFields());
        temp.add(new Field(Integer.class, numberOfPorts));
        temp.add(new Field(String.class, portsType.name()));
        temp.add(new Field(Connection[].class, Arrays.copyOf(portsConnections, portsConnections.length)));
        return temp;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        super.fillAllFields(fields);
        setNumberOfPorts((Integer) checkField(fields));
        portsType = ConnectorType.valueOf((String) checkField(fields));
        portsConnections = (Connection[]) checkField(fields);
    }

    private boolean checkPort(int portNumber) {
        if(portNumber >= 0 && portNumber <= numberOfPorts - 1) return true;
        IndexOutOfBoundsException e = new IndexOutOfBoundsException(" IndexOutOfBounds");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

}
