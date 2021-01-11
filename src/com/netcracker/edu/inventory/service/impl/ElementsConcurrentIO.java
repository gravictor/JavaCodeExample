package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.FillableEntity;
import com.netcracker.edu.inventory.model.NetworkElement;
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

public class ElementsConcurrentIO {

    private static final Logger log = Logger.getLogger(ElementsConcurrentIO.class.getName());
    IOService ioService = new IOServiceImpl();

    public void parallelOutputElements(Collection<NetworkElement> elements, OutputStream outputStream) {
        try {
            for (FillableEntity element : elements)
                if (ioService.isValidEntityForOutputToStream(element))
                    ioService.outputFillableEntity(element, outputStream);
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage(), e);
        }
    }
    public Collection<NetworkElement> parallelInputElements(int number, InputStream inputStream) {
        List<NetworkElement> networkElements = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            try {
                networkElements.add((NetworkElement) ioService.inputFillableEntity(inputStream));
            } catch (Exception e) {
                log.log(Level.WARNING, e.getMessage(), e);
            }
        }
        return networkElements;
    }
}
