package com.netcracker.edu.inventory.model.device.entity.impl;

import com.netcracker.edu.inventory.model.impl.AbstractDevice;

import java.util.Queue;

public class Battery extends AbstractDevice implements com.netcracker.edu.inventory.model.device.entity.Battery {
    protected int chargeVolume;

    public int getChargeVolume() {
        return chargeVolume;
    }
    public void setChargeVolume(int chargeVolume) {
        this.chargeVolume = chargeVolume;
    }

    @Override
    public void fillAllFields(Queue<Field> fields){
        if(fields!= null) {
            super.fillAllFields(fields);
            setChargeVolume((Integer)  checkField(fields));
        }
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> t = super.getAllFields();
        t.add(new Field(Integer.class, chargeVolume));
        return t;
    }
}
