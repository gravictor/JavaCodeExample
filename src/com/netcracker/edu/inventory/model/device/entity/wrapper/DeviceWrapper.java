package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.device.impl.DevicePK;

import java.util.Date;
import java.util.Queue;

public class DeviceWrapper implements Device {

    AbstractDeviceWrapper abstractDeviceWrapper;

    public DeviceWrapper(AbstractDeviceWrapper abstractDeviceWrapper) {
        this.abstractDeviceWrapper = abstractDeviceWrapper;
    }

    @Override
    public int getIn() {
        return abstractDeviceWrapper.getIn();
    }

    @Override
    public void setIn(int in) {
        abstractDeviceWrapper.setIn(in);

    }

    @Override
    public String getType() {
        return abstractDeviceWrapper.getType();
    }

    @Override
    public void setType(String type) {
        abstractDeviceWrapper.setType(type);
    }

    @Override
    public String getManufacturer() {
        return abstractDeviceWrapper.getManufacturer();
    }

    @Override
    public void setManufacturer(String manufacturer) {
        abstractDeviceWrapper.setManufacturer(manufacturer);
    }

    @Override
    public String getModel() {
        return abstractDeviceWrapper.getModel();
    }

    @Override
    public void setModel(String model) {
        abstractDeviceWrapper.setModel(model);
    }

    @Override
    public Date getProductionDate() {
        return abstractDeviceWrapper.getProductionDate();
    }

    @Override
    public void setProductionDate(Date productionDate) {
        abstractDeviceWrapper.setProductionDate(productionDate);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) throws Exception {
        abstractDeviceWrapper.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return abstractDeviceWrapper.getAllFields();
    }

    @Override
    public int compareTo(Device o) {
        return abstractDeviceWrapper.compareTo(o);
    }

    public AbstractDeviceWrapper getAbstractDeviceWrapper() {
        return this.abstractDeviceWrapper;
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
