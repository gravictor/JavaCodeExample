package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.device.Device;

class FilterService {
    public void filtrateByType(Device[] devices, String type) {
        for (int i = 0; i<devices.length; i++) {
            if ((devices[i] != null) && (type != null)) {
                if (devices[i].getType() == null)
                    devices[i] = null;
                else if (!devices[i].getType().equalsIgnoreCase(type))
                    devices[i] = null;
            }
            if ((type == null)&&(devices[i] != null)) {
                if (devices[i].getType() != null)
                    devices[i] = null;
            }
        }
    }
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        for (int i = 0; i<devices.length; i++) {
            if ((devices[i] != null) && (manufacturer != null)) {
                if (devices[i].getManufacturer() == null)
                    devices[i] = null;
                else if (!devices[i].getManufacturer().equalsIgnoreCase(manufacturer))
                    devices[i] = null;
            }
            if ((manufacturer == null)&&(devices[i] != null)) {
                if (devices[i].getManufacturer() != null)
                    devices[i] = null;
            }
        }
    }
    public void filtrateByModel(Device[] devices, String model) {
        for (int i = 0; i<devices.length; i++) {
            if ((devices[i] != null) && (model != null)) {
                if (devices[i].getModel() == null)
                    devices[i] = null;
                else if (!devices[i].getModel().equalsIgnoreCase(model))
                    devices[i] = null;
            }
            if ((model == null)&&(devices[i] != null)) {
                if (devices[i].getModel() != null)
                    devices[i] = null;
            }
        }
    }
}
