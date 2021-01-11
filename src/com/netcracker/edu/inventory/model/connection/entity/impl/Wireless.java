package com.netcracker.edu.inventory.model.connection.entity.impl;


import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractOneToManyConnection;

import java.util.ArrayDeque;
import java.util.Queue;

public class Wireless<A extends Device, B extends Device> extends AbstractOneToManyConnection<A, B> implements com.netcracker.edu.inventory.model.connection.entity.Wireless {

    private String technology;
    private String protocol;
    private int version;


    public Wireless() {
        super();
    }

    public Wireless(int maxSize, String technology) {
        super(maxSize);
        setTechnology(technology);
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String getTechnology() {
        return technology;
    }

    private void setTechnology(String technology) {
        if (this.technology == null) {
            this.technology = technology;
        }
    }

    @Override
    public void fillAllFields(Queue queue) {
        super.fillAllFields(queue);
        setTechnology((String) super.getNext(queue));
        setProtocol((String) super.getNext(queue));
        setVersion((Integer) super.getNext(queue));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> queue = new ArrayDeque<>();
        queue.addAll(super.getAllFields());
        queue.add(new Field(String.class, technology));
        queue.add(new Field(String.class, protocol));
        queue.add(new Field(Integer.class, version));
        return queue;
    }
}
