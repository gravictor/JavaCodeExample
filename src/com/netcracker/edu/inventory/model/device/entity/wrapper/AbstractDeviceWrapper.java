package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.FillableEntity;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.device.entity.*;
import com.netcracker.edu.inventory.model.device.impl.DevicePK;

import java.util.Date;
import java.util.List;
import java.util.Queue;

public class AbstractDeviceWrapper implements AllDevices {

    Battery battery;
    WifiRouter wifiRouter;
    Switch aSwitch;
    Router router;

    public AbstractDeviceWrapper(Device device) {
        if(device instanceof Battery) this.battery = (Battery) device;
        if(device instanceof WifiRouter) this.wifiRouter = (WifiRouter) device;
        if(device instanceof Switch) this.aSwitch = (Switch) device;
        if(device instanceof Router) this.router = (Router) device;
    }

    @Override
    public int getIn() {
        if(battery != null) return battery.getIn();
        else if (wifiRouter != null) return wifiRouter.getIn();
        else if(aSwitch != null) return aSwitch.getIn();
        else return router.getIn();
    }

    @Override
    public void setIn(int in) {
        if(battery != null)  battery.setIn(in);
        else if (wifiRouter != null)  wifiRouter.setIn(in);
        else if(aSwitch != null)  aSwitch.setIn(in);
        else  router.setIn(in);
    }

    @Override
    public String getType() {
        if(battery != null) return battery.getType();
        else if (wifiRouter != null) return wifiRouter.getType();
        else if(aSwitch != null) return aSwitch.getType();
        else return router.getType();
    }

    @Override
    public void setType(String type) {
        if(battery != null)  battery.setType(type);
        else if (wifiRouter != null)  wifiRouter.setType(type);
        else if(aSwitch != null)  aSwitch.setType(type);
        else  router.setType(type);
    }

    @Override
    public String getManufacturer() {
        if(battery != null) return battery.getManufacturer();
        else if (wifiRouter != null) return wifiRouter.getManufacturer();
        else if(aSwitch != null) return aSwitch.getManufacturer();
        else return router.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        if(battery != null)  battery.setManufacturer(manufacturer);
        else if (wifiRouter != null)  wifiRouter.setManufacturer(manufacturer);
        else if(aSwitch != null)  aSwitch.setManufacturer(manufacturer);
        else  router.setManufacturer(manufacturer);
    }

    @Override
    public String getModel() {
        if(battery != null) return battery.getModel();
        else if (wifiRouter != null) return wifiRouter.getModel();
        else if(aSwitch != null) return aSwitch.getModel();
        else return router.getModel();
    }

    @Override
    public void setModel(String model) {
        if(battery != null)  battery.setModel(model);
        else if (wifiRouter != null)  wifiRouter.setModel(model);
        else if(aSwitch != null)  aSwitch.setModel(model);
        else  router.setModel(model);
    }

    @Override
    public Date getProductionDate() {
        if(battery != null) return battery.getProductionDate();
        else if (wifiRouter != null) return wifiRouter.getProductionDate();
        else if(aSwitch != null) return aSwitch.getProductionDate();
        else return router.getProductionDate();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        if(battery != null)  battery.setProductionDate(productionDate);
        else if (wifiRouter != null)  wifiRouter.setProductionDate(productionDate);
        else if(aSwitch != null)  aSwitch.setProductionDate(productionDate);
        else  router.setProductionDate(productionDate);
    }

    @Override
    public void fillAllFields(Queue<FillableEntity.Field> fields) throws Exception {
        if(battery != null)  battery.fillAllFields(fields);
        else if (wifiRouter != null)  wifiRouter.fillAllFields(fields);
        else if(aSwitch != null)  aSwitch.fillAllFields(fields);
        else  router.fillAllFields(fields);
    }

    @Override
    public Queue<FillableEntity.Field> getAllFields() {
        if(battery != null) return battery.getAllFields();
        else if (wifiRouter != null) return wifiRouter.getAllFields();
        else if(aSwitch != null) return aSwitch.getAllFields();
        else return router.getAllFields();
    }

    @Override
    public int compareTo(Device o) {
        if(battery != null) return battery.compareTo(o);
        else if (wifiRouter != null) return wifiRouter.compareTo(o);
        else if(aSwitch != null) return aSwitch.compareTo(o);
        else return router.compareTo(o);
    }

    @Override
    public int getChargeVolume() {
        return battery.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        battery.setChargeVolume(chargeVolume);
    }

    @Override
    public int getNumberOfPorts() {
        return aSwitch.getNumberOfPorts();
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        aSwitch.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public ConnectorType getPortsType() {
        return aSwitch.getPortsType();
    }

    @Override
    public Connection getPortConnection(int portNumber) {
        return aSwitch.getPortConnection(portNumber);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        aSwitch.setPortConnection(connection, portNumber);
    }

    @Override
    public List<Connection> getAllPortConnections() {
        return aSwitch.getAllPortConnections();
    }

    @Override
    public int getDataRate() {
        return router.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        router.setDataRate(dataRate);
    }

    @Override
    public String getTechnologyVersion() {
        return wifiRouter.getTechnologyVersion();
    }

    @Override
    public String getSecurityProtocol() {
        return wifiRouter.getSecurityProtocol();
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        wifiRouter.setSecurityProtocol(securityProtocol);
    }

    @Override
    public Connection getWirelessConnection() {
        return wifiRouter.getWirelessConnection();
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        wifiRouter.setWirelessConnection(wirelessConnection);
    }

    @Override
    public ConnectorType getWirePortType() {
        return wifiRouter.getWirePortType();
    }

    @Override
    public Connection getWireConnection() {
        return wifiRouter.getWireConnection();
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        wifiRouter.setWireConnection(wireConnection);
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public DevicePrimaryKey getPrimaryKey() {
        if(getIn() ==0)
            return null;
        return new DevicePK(getIn());
    }
}
