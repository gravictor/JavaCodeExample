package com.netcracker.edu.inventory.model.connection.entity;

import com.netcracker.edu.inventory.model.device.Device;

public interface AllConnections<A extends Device> extends OpticFiber<A,A>, ThinCoaxial<A>, TwistedPair<A,A>, Wireless<A,A>{
}

