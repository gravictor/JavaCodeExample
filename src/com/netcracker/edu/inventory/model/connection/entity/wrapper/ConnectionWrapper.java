package com.netcracker.edu.inventory.model.connection.entity.wrapper;

import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.model.connection.ConnectionPrimaryKey;
import com.netcracker.edu.inventory.model.connection.impl.ConnectionPK;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.location.Trunk;

import java.util.Queue;

public class ConnectionWrapper<A extends Device> implements Connection<A, A> {

    AbstractConnectionWrapper<A> abstractConnectionWrapper;

    public AbstractConnectionWrapper<A> getAbstractConnectionWrapper(){
        return this.abstractConnectionWrapper;
    }

    public ConnectionWrapper(AbstractConnectionWrapper<A> abstractConnectionWrapper){
        this.abstractConnectionWrapper = abstractConnectionWrapper;
    }

    @Override
    public Trunk getTrunk() {
        return abstractConnectionWrapper.getTrunk();
    }

    @Override
    public void setTrunk(Trunk trunk) {
        abstractConnectionWrapper.setTrunk(trunk);
    }

    @Override
    public int getSerialNumber() {
        return abstractConnectionWrapper.getSerialNumber();
    }

    @Override
    public void setSerialNumber(int serialNumber) {
        abstractConnectionWrapper.setSerialNumber(serialNumber);
    }

    @Override
    public String getStatus() {
        return abstractConnectionWrapper.getStatus();
    }

    @Override
    public void setStatus(String status) {
        abstractConnectionWrapper.setStatus(status);
    }

    @Override
    public void fillAllFields(Queue<Field> fields) throws Exception {
        abstractConnectionWrapper.fillAllFields(fields);
    }

    @Override
    public Queue<Field> getAllFields() {
        return abstractConnectionWrapper.getAllFields();
    }

    @Override
    public int compareTo(Connection o) {
        return abstractConnectionWrapper.compareTo(o);
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public ConnectionPrimaryKey getPrimaryKey() {
        if(getTrunk() ==null || getSerialNumber() == 0)
            return null;
        return new ConnectionPK(getTrunk(), getSerialNumber());
    }
}
