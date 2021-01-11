package com.netcracker.edu.inventory.model.connection.entity.impl;

import com.netcracker.edu.inventory.model.connection.ConnectorType;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.impl.AbstractAllToAllConnection;

import java.util.HashSet;

public class ThinCoaxial<A extends Device> extends AbstractAllToAllConnection<A> implements com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial {

    public ThinCoaxial(){
        this(0);
    }

    public ThinCoaxial(int maxSize){
        connectorType = ConnectorType.TConnector;
        this.maxSize = maxSize;
        this.devices = new HashSet<>(maxSize);
    }
}
