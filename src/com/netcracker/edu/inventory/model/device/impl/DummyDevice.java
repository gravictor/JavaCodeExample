package com.netcracker.edu.inventory.model.device.impl;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.impl.AbstractDevice;

import java.util.Date;
import java.util.Objects;
import java.util.Queue;

public class DummyDevice extends AbstractDevice implements Device {

    DevicePrimaryKey devicePrimaryKey;

    public DummyDevice(DevicePrimaryKey devicePK) {
        this.devicePrimaryKey = devicePK;
    }

    @Override
    public int getIn() {
        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public void setIn(int in) {

        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public void setType(String type) {

        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public String getManufacturer() {
        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public void setManufacturer(String manufacturer) {

        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public Date getProductionDate() {
        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public void setProductionDate(Date productionDate) {

        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public String getModel() {
        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public void setModel(String model) {

        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public Queue<Field> getAllFields() {
        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public void fillAllFields(Queue<Field> fields) {

        throw new UnsupportedOperationException("Device is dummy");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DummyDevice that = (DummyDevice) o;
        return Objects.equals(hashCode(), that.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPrimaryKey());
    }

    @Override
    public DevicePrimaryKey getPrimaryKey() {
        return devicePrimaryKey;
    }

    @Override
    public int compareTo(Device o) {
        return Integer.compare(this.getPrimaryKey().getIn(), o.getPrimaryKey().getIn());
    }
}
