package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractOneToOneConnection;

import java.util.ArrayDeque;
import java.util.Queue;

public class OpticFiber <A extends Device, B extends Device> extends AbstractOneToOneConnection<A, B> implements com.netcracker.edu.inventory.model.connection.entity.OpticFiber {
    private com.netcracker.edu.inventory.model.connection.entity.OpticFiber.Mode mode;

    public OpticFiber() {
        super(ConnectorType.FiberConnector_FC);
        mode = com.netcracker.edu.inventory.model.connection.entity.OpticFiber.Mode.need_init;
    }

    public OpticFiber(com.netcracker.edu.inventory.model.connection.entity.OpticFiber.Mode mode,int length) {
        super(length, ConnectorType.FiberConnector_FC);
        if(mode == null){
            this.mode = com.netcracker.edu.inventory.model.connection.entity.OpticFiber.Mode.need_init;
        }
        else {
            this.mode = mode;
        }
    }

    private void setMode(com.netcracker.edu.inventory.model.connection.entity.OpticFiber.Mode mode) {
        if (this.mode.equals(Mode.need_init))
            this.mode = mode;
    }

    public com.netcracker.edu.inventory.model.connection.entity.OpticFiber.Mode getMode() {
        return mode;
    }

    @Override
    public void fillAllFields(Queue queue) {
        super.fillAllFields(queue);
        setMode(com.netcracker.edu.inventory.model.connection.entity.OpticFiber.Mode.valueOf((String) super.getNext(queue)));
    }

    @Override
    public Queue<Field>  getAllFields() {
        Queue<Field> queue = new ArrayDeque<>();
        queue.addAll(super.getAllFields());
        queue.add(new Field(String.class, mode.name()));
        return queue;
    }
}
