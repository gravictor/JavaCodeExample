package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.impl.AbstractDevice;

import java.util.Queue;

public class Router extends AbstractDevice implements com.netcracker.edu.inventory.model.device.entity.Router {
    protected int dataRate;

    public int getDataRate() {
        return dataRate;
    }
    public void setDataRate(int dataRate) {
        this.dataRate = dataRate;
    }

    @Override
    public void fillAllFields(Queue<Field> fields)  {
        super.fillAllFields(fields);
        setDataRate((Integer)  checkField(fields));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> t = super.getAllFields();
        t.add(new Field(Integer.class, dataRate));
        return t;
    }
}
