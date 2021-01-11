package com.netcracker.edu.inventory.exception;
import com.netcracker.edu.inventory.model.device.Device;

public class DeviceValidationException extends RuntimeException{
    private Device device;
    protected static final String defaultMessage = "Device is not valid for operation";

    public DeviceValidationException(){
        super();
    }

    public DeviceValidationException(String operation){
        super(operation != null ? (defaultMessage + " " + operation) : (defaultMessage));
    }

    public DeviceValidationException(String operation, Device device){
        this(operation);
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }
}
