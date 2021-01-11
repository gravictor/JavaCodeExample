package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.exception.ConnectionValidationException;
import com.netcracker.edu.inventory.exception.DeviceValidationException;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.service.DeviceService;
import com.netcracker.edu.io.IOService;
import com.netcracker.edu.io.impl.IOServiceImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class DeviceServiceImpl implements DeviceService {

    private static final IOService service = new IOServiceImpl();
    private RDBProvider rdbProvider = new RDBProvider();
    private final static Logger log = Logger.getLogger(DeviceServiceImpl.class.getName());
    SortService sort = new SortService();
    //EntityFactory serviceImpl = new EntityFactoryImpl();
    FilterService filter = new FilterService();

    @Override
    public void sortByIN(Device[] devices) {
        sort.sortByIN(devices);
    }

    @Override
    public void sortByProductionDate(Device[] devices) {
        sort.sortByProductionDate(devices);
    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        filter.filtrateByType(devices,type);
    }

    @Override
    public void filtrateByManufacturer(Device[] devices, String manufacturer) {
        filter.filtrateByManufacturer(devices, manufacturer);
    }

    @Override
    public void filtrateByModel(Device[] devices, String model) {
        filter.filtrateByModel(devices, model);
    }

    @Override
    public boolean isValidDeviceForInsertToRack(Device device) {
        if(device == null) return false;
        return device.getIn() > 0 && !device.isLazy();
    }

    @Override
    public boolean isValidDeviceForOutputToStream(Device device) {
        return service.isValidEntityForOutputToStream(device);
    }

    @Override
    public void outputDevice(Device device, OutputStream outputStream) throws IOException {
        if(service.isValidEntityForOutputToStream(device))
            service.outputFillableEntity(device, outputStream);
        else {
            DeviceValidationException e = new DeviceValidationException("Deice is not valid");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Device inputDevice(InputStream inputStream) throws IOException, ClassNotFoundException {
        try {
            return (Device)service.inputFillableEntity(inputStream);
        }
        catch (ConnectionValidationException exception){
            throw exception;
        }
    }

    @Override
    public Device getDeviceFromDB(Connection dbConnection, DevicePrimaryKey dpk) throws Exception {
        return rdbProvider.getDevice(dbConnection, dpk);
    }

    @Override
    public boolean putDeviceToDB(Connection dbConnection, Device device) throws SQLException {
        return rdbProvider.putDevice(dbConnection, device);
    }

    @Override
    public boolean removeDeviceFromDB(Connection dbConnection, DevicePrimaryKey dpk) throws SQLException {
        return rdbProvider.removeDevice(dbConnection, dpk);
    }

}
