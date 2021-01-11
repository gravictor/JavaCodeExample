package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;

import java.util.ArrayDeque;
import java.util.Queue;

public class WifiRouter extends Router implements com.netcracker.edu.inventory.model.device.entity.WifiRouter {

    protected String securityProtocol;
    private String technologyVersion;
    private Connection wirelessConnection;
    private ConnectorType wirePortType;
    private Connection wireConnection;

    public WifiRouter() {
        wirePortType = ConnectorType.need_init;
    }

    public WifiRouter(String technologyVersion, ConnectorType wirePortType) {
        this.technologyVersion = technologyVersion;
        if (wirePortType == null) {
            this.wirePortType = ConnectorType.need_init;
        } else this.wirePortType = wirePortType;
    }


    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
    }

    public String getTechnologyVersion() {
        return technologyVersion;
    }

    public void setTechnologyVersion(String technologyVersion) {
        if(this.technologyVersion == null) this.technologyVersion = technologyVersion;
    }

    public Connection getWirelessConnection() {
        return wirelessConnection;
    }

    public void setWirelessConnection(Connection wirelessConnection) {
        this.wirelessConnection = wirelessConnection;
    }

    public ConnectorType getWirePortType() {
        return wirePortType;
    }

    public void setWirePortType(ConnectorType wirePortType) {
        if (this.wirePortType.equals(ConnectorType.need_init)) this.wirePortType = wirePortType;
    }

    public Connection getWireConnection() {
        return wireConnection;
    }

    public void setWireConnection(Connection wireConnection) {
        this.wireConnection = wireConnection;
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> temp = new ArrayDeque<>();
        temp.addAll(super.getAllFields());
        temp.add(new Field(String.class, securityProtocol));
        temp.add(new Field(String.class, technologyVersion));
        temp.add(new Field(Connection.class, wirelessConnection));
        temp.add(new Field(String.class, wirePortType.name()));
        temp.add(new Field(Connection.class, wireConnection));
        return temp;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        super.fillAllFields(fields);
        setSecurityProtocol((String) checkField(fields));
        setTechnologyVersion((String) checkField(fields));
        setWirelessConnection((Connection) checkField(fields));
        setWirePortType(ConnectorType.valueOf((String) checkField(fields)));
        setWireConnection((Connection) checkField(fields));
    }
}
