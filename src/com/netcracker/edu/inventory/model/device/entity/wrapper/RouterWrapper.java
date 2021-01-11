package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Router;

public class RouterWrapper extends DeviceWrapper implements Router {
    public RouterWrapper(AbstractDeviceWrapper abstractDeviceWrapper) {
        super(abstractDeviceWrapper);
    }

    @Override
    public int getDataRate() {
        return abstractDeviceWrapper.getDataRate();
    }

    @Override
    public void setDataRate(int dataRate) {
        abstractDeviceWrapper.setDataRate(dataRate);
    }
}
