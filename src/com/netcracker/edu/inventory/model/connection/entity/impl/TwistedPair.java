package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractOneToOneConnection;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwistedPair<A extends Device, B extends Device> extends AbstractOneToOneConnection<A, B> implements com.netcracker.edu.inventory.model.connection.entity.TwistedPair {
    private com.netcracker.edu.inventory.model.connection.entity.TwistedPair.Type type;

    public TwistedPair() {
        super(ConnectorType.RJ45);
        type = com.netcracker.edu.inventory.model.connection.entity.TwistedPair.Type.need_init;
    }

    public TwistedPair(com.netcracker.edu.inventory.model.connection.entity.TwistedPair.Type type, int length) {
        super(length, ConnectorType.RJ45);
        if (type == null) {
            this.type = com.netcracker.edu.inventory.model.connection.entity.TwistedPair.Type.need_init;
        } else this.type = type;
    }

    public com.netcracker.edu.inventory.model.connection.entity.TwistedPair.Type getType() {
        return this.type;
    }

    private void setType(com.netcracker.edu.inventory.model.connection.entity.TwistedPair.Type type) {
        this.type = type;
    }


    @Override
    public void fillAllFields(Queue queue) {
        super.fillAllFields(queue);
        setType(com.netcracker.edu.inventory.model.connection.entity.TwistedPair.Type.valueOf((String) super.getNext(queue)));
    }

    @Override
    public Queue<Field> getAllFields() {
        Queue<Field> queue = new ArrayDeque<>();
        queue.addAll(super.getAllFields());
        queue.add(new Field(String.class, type.name()));
        return queue;
    }
}
