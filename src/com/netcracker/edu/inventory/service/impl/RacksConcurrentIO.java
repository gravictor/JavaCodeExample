package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RacksConcurrentIO {

    private static final Logger log = Logger.getLogger(RacksConcurrentIO.class.getName());
    IOService ioService = new IOServiceImpl();
    public void parallelOutputRacks(Collection<Rack> racks, OutputStream outputStream) {
        try {
            for (Rack rack : racks)
                if (ioService.isValidRackForOutputToStream(rack))
                    ioService.outputRack(rack, outputStream);
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public Collection<Rack> parallelInputRacks(int number, InputStream inputStream) {
        List<Rack> racks = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            try {
                racks.add(ioService.inputRack(inputStream));
            } catch (Exception e) {
                log.log(Level.WARNING, e.getMessage(), e);
            }
        }
        return racks;
    }
}
