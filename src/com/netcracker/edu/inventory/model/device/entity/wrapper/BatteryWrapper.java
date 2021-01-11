package com.netcracker.edu.inventory.model.device.entity.wrapper;

import com.netcracker.edu.inventory.model.device.entity.Battery;

public class BatteryWrapper extends DeviceWrapper implements Battery {
    public BatteryWrapper(AbstractDeviceWrapper abstractDeviceWrapper) {
        super(abstractDeviceWrapper);
    }

    @Override
    public int getChargeVolume() {
        return abstractDeviceWrapper.getChargeVolume();
    }

    @Override
    public void setChargeVolume(int chargeVolume) {
        abstractDeviceWrapper.setChargeVolume(chargeVolume);
    }
}
