package com.netcracker.edu.inventory.exception;

import com.netcracker.edu.inventory.model.connection.Connection;

public class ConnectionValidationException extends RuntimeException{
    Connection connection;
    protected static final String defaultMessage = "Connection is not valid for operation";

    public ConnectionValidationException(){
        super();
    }

    public ConnectionValidationException(String operation){
        super(operation != null ? (defaultMessage + " " + operation) : (defaultMessage));
    }

    public ConnectionValidationException(String operation, Connection connection){
        this(operation);
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
