package com.netcracker.edu.inventory.model.device.impl;

import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;

import java.util.Objects;

public class DevicePK implements DevicePrimaryKey {

    int in;

    public DevicePK(int in) {
        this.in = in;
    }

    @Override
    public int getIn() {
        return in;
    }

    @Override
    public int compareTo(DevicePrimaryKey o) {
        return Integer.compare(this.in, o.getIn());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevicePK devicePK = (DevicePK) o;
        return hashCode() == devicePK.hashCode();
    }

    @Override
    public int hashCode() {
        return in;
    }
}
