package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.entity.WifiRouter;

public class WifiRouterWrapper extends RouterWrapper implements WifiRouter {
    public WifiRouterWrapper(AbstractDeviceWrapper abstractDeviceWrapper) {
        super(abstractDeviceWrapper);
    }

    @Override
    public String getTechnologyVersion() {
        return abstractDeviceWrapper.getTechnologyVersion();
    }

    @Override
    public String getSecurityProtocol() {
        return abstractDeviceWrapper.getSecurityProtocol();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        abstractDeviceWrapper.setSecurityProtocol(securityProtocol);
    }

    @Override
    public Connection getWirelessConnection() {
        return abstractDeviceWrapper.getWirelessConnection();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        abstractDeviceWrapper.setWirelessConnection(wirelessConnection);
    }

    @Override
    public ConnectorType getWirePortType() {
        return abstractDeviceWrapper.getWirePortType();
    }

    @Override
    public Connection getWireConnection() {
        return abstractDeviceWrapper.getWireConnection();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        abstractDeviceWrapper.setWireConnection(wireConnection);
    }
}
