package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.device.Device;
import java.util.Arrays;
import java.util.Comparator;

class SortService {
    public void sortByProductionDate(Device[] devices) {
        Arrays.sort(devices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if (o1 == null)
                    return 1;
                if(o2 == null)
                    return -1;
                if(o1 == null && o2 == null)
                    return 0;
                if (o1 != null && o2 != null) {
                    if (o1.getProductionDate() == null && o2.getProductionDate() == null) {
                        return 0;
                    }
                    if (o1.getProductionDate() == null) {
                        return 1;
                    }
                    if (o2.getProductionDate() == null) {
                        return -1;
                    }
                    return o1.getProductionDate().compareTo(o2.getProductionDate());
                }
                return 0;
            }
        });
    }
    public void sortByIN(Device[] devices) {
        Arrays.sort(devices, new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                if (o1 == null) return 1;
                if(o2 == null) return -1;
                if(o1 == null && o2 == null) return 0;
                if (o1 != null && o2 != null) {
                    if (o1.getIn() == 0 && o2.getIn() == 0) {
                        return 0;
                    }
                    if (o1.getIn() == 0) {
                        return 1;
                    }
                    if (o2.getIn() == 0) {
                        return -1;
                    }
                    return (o1.getIn()<o2.getIn() ? -1 :(o1.getIn() == o2.getIn()) ? 0: 1);
                }
                return 0;
            }
        });
    }
}
