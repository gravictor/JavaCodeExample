package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.device.Device;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevicesPublisherWrapper extends AbstractDeviceWrapper implements PropertyChangeListener {

    protected List<PropertyChangeListener> listeners = new ArrayList<>();
    DevicesPublisherWrapper devicesPublisherWrapper;

    public DevicesPublisherWrapper(Device wrapper) {
        super(wrapper);
        if(wrapper instanceof DeviceWrapper) {
            DeviceWrapper deviceWrapper = (DeviceWrapper) wrapper;
            if(deviceWrapper.getAbstractDeviceWrapper() instanceof DevicesPublisherWrapper) {
                devicesPublisherWrapper = (DevicesPublisherWrapper) deviceWrapper.getAbstractDeviceWrapper();
                listeners = devicesPublisherWrapper.listeners;
            }
        }
    }

    @Override
    public void setIn(int in) {
        propertyChange(new PropertyChangeEvent(this, "in", this.getIn(), in));
        super.setIn(in);
    }

    @Override
    public void setType(String type) {
        propertyChange(new PropertyChangeEvent(this, "type", this.getType(), type));
        super.setType(type);
    }

    @Override
    public void setManufacturer(String manufacturer) {
        propertyChange(new PropertyChangeEvent(this, "manufacturer", this.getManufacturer(), manufacturer));
        super.setManufacturer(manufacturer);
    }

    @Override
    public void setModel(String model) {
        propertyChange(new PropertyChangeEvent(this, "model", this.getModel(), model));
        super.setModel(model);
    }

    @Override
    public void setProductionDate(Date productionDate) {
        propertyChange(new PropertyChangeEvent(this, "productionDate", this.getProductionDate(), productionDate));
        super.setProductionDate(productionDate);
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        propertyChange(new PropertyChangeEvent(this, "chargeVolume", battery.getChargeVolume(), chargeVolume));
        battery.setChargeVolume(chargeVolume);
    }

    @Override
    public void setDataRate(int dataRate) {
        propertyChange(new PropertyChangeEvent(this, "dataRate", router.getDataRate(), dataRate));
        router.setDataRate(dataRate);
    }

    @Override
    public void setNumberOfPorts(int numberOfPorts) {
        propertyChange(new PropertyChangeEvent(this, "numberOfPorts", aSwitch.getNumberOfPorts(), numberOfPorts));
        aSwitch.setNumberOfPorts(numberOfPorts);
    }

    @Override
    public void setPortConnection(Connection connection, int portNumber) {
        propertyChange(new PropertyChangeEvent(this, "portConnection", aSwitch.getPortConnection(portNumber), connection));
        aSwitch.setPortConnection(connection, portNumber);
    }

    @Override
    public void setSecurityProtocol(String securityProtocol) {
        propertyChange(new PropertyChangeEvent(this, "securityProtocol", wifiRouter.getSecurityProtocol(), securityProtocol));
        wifiRouter.setSecurityProtocol(securityProtocol);
    }

    @Override
    public void setWirelessConnection(Connection wirelessConnection) {
        propertyChange(new PropertyChangeEvent(this, "wirelessConnection", wifiRouter.getWirelessConnection(), wirelessConnection));
        wifiRouter.setWirelessConnection(wirelessConnection);
    }

    @Override
    public void setWireConnection(Connection wireConnection) {
        propertyChange(new PropertyChangeEvent(this, "wireConnection", wifiRouter.getWireConnection(), wireConnection));
        wifiRouter.setWireConnection(wireConnection);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        for (PropertyChangeListener listener:listeners) {
            listener.propertyChange(evt);
        }
    }

    public void subscribe(PropertyChangeListener device) {
        listeners.add(device);
    }

    public boolean unsubscribe(PropertyChangeListener listener){
        return listeners.remove(listener);
    }

}
