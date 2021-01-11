package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.ConnectionValidationException;
import com.netcracker.edu.inventory.model.connection.Connection;
import com.netcracker.edu.inventory.service.ConnectionService;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConnectionServiceImpl implements ConnectionService {

    private static final IOService service = new IOServiceImpl();
    private final static Logger log = Logger.getLogger(ConnectionServiceImpl.class.getName());

    @Override
    public boolean isValidConnectionForOutputToStream(Connection connection) {
        return service.isValidEntityForOutputToStream(connection);
    }

    @Override
    public void outputConnection(Connection connection, OutputStream outputStream) throws IOException {
        if(!isValidConnectionForOutputToStream(connection)){
            ConnectionValidationException exception = new ConnectionValidationException("Connection isn`t valid");
            log.log(Level.SEVERE, exception.getMessage(), exception);
            throw exception;
        }
        else service.outputFillableEntity(connection, outputStream);
    }

    @Override
    public Connection inputConnection(InputStream inputStream) throws IOException, ClassNotFoundException {
        return (Connection) service.inputFillableEntity(inputStream);
    }
}
