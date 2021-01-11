package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.device.impl.DevicePK;
import com.netcracker.edu.inventory.model.device.impl.DummyDevice;

import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDevice implements Device {

    private final static Logger log = Logger.getLogger(AbstractDevice.class.getName());
    protected int         in = 0;
    protected String      type;
    protected String      manufacturer;
    protected String      model;
    protected Date        productionDate;

    @Override
    public boolean isLazy() {
        return this instanceof DummyDevice;
    }

    @Override
    public DevicePrimaryKey getPrimaryKey() {
        if(in ==0)
            return null;
        return new DevicePK(in);
    }

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public void setIn(int in) {
        if (in < 0) {
            IllegalArgumentException e = new IllegalArgumentException("IN can not be negative");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
        if (this.in != 0) {
            log.warning("Inventory number can not be reset");
        } else {
            this.in = in;
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        setIn((Integer) checkField(fields));
        setType((String)  checkField(fields));
        setManufacturer((String)  checkField(fields));
        setModel((String)  checkField(fields));
        setProductionDate((Date) checkField(fields));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> field = new LinkedList<>();
        field.add(new Field(Integer.class, in));
        field.add(new Field(String.class, type));
        field.add(new Field(String.class, manufacturer));
        field.add(new Field(String.class, model));
        field.add(new Field(Date.class, productionDate));

        return field;
    }

    protected Object checkField(Queue<Field> fields){
        if(fields.peek() == null){
            NoSuchElementException exception = new NoSuchElementException("The queue is empty");
            log.log(Level.SEVERE, exception.getMessage(),exception);
            throw exception;
        }
        return fields.poll().getValue();
    }

    public AbstractDevice() {
        super();
    }

    @Override
    public int compareTo(Device o) {
        if(o ==null)
            return -1;
        return Integer.compare(this.in, o.getIn());
    }
}
