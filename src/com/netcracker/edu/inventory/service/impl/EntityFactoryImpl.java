package com.netcracker.edu.inventory.service.impl;

import com.netcracker.edu.inventory.model.NetworkElement;
import com.netcracker.edu.inventory.model.Unique;
import com.netcracker.edu.inventory.model.connection.*;
import com.netcracker.edu.inventory.model.connection.entity.impl.*;
import com.netcracker.edu.inventory.model.connection.entity.wrapper.*;
import com.netcracker.edu.inventory.model.connection.impl.ConnectionPK;
import com.netcracker.edu.inventory.model.connection.impl.DummyConnection;
import com.netcracker.edu.inventory.model.device.Device;
import com.netcracker.edu.inventory.model.device.DevicePrimaryKey;
import com.netcracker.edu.inventory.model.device.entity.impl.*;
import com.netcracker.edu.inventory.model.device.entity.wrapper.*;
import com.netcracker.edu.inventory.model.device.impl.DevicePK;
import com.netcracker.edu.inventory.model.device.impl.DummyDevice;
import com.netcracker.edu.inventory.model.rack.Rack;
import com.netcracker.edu.inventory.model.rack.RackPrimaryKey;
import com.netcracker.edu.inventory.model.rack.impl.RackArrayImpl;
import com.netcracker.edu.inventory.model.rack.impl.RackPK;
import com.netcracker.edu.inventory.model.rack.wrapper.RackImmutableWrapper;
import com.netcracker.edu.inventory.model.rack.wrapper.RackPublisherWrapper;
import com.netcracker.edu.inventory.model.rack.wrapper.RackSynchronizedWrapper;
import com.netcracker.edu.inventory.service.EntityFactory;
import com.netcracker.edu.location.Location;
import com.netcracker.edu.location.Trunk;

import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntityFactoryImpl implements EntityFactory {
    protected static final Logger log = Logger.getLogger(EntityFactoryImpl.class.getName());

    @Override
    public NetworkElement createEmptyNetworkElementImpl(String className) throws IllegalArgumentException {
        try {
            if(className != null && NetworkElement.class.isAssignableFrom(Class.forName(className))) {
                Class clazz = Class.forName(className);
                return createEmptyNetworkElementImpl(clazz);
            }
        } catch (ClassNotFoundException e) {

        }
        IllegalArgumentException e = new IllegalArgumentException("className = null. IllegalArgumentException");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    @Override
    public <T extends NetworkElement> T createEmptyNetworkElementImpl(Class<T> clazz) throws IllegalArgumentException {
        if (clazz != null && NetworkElement.class.isAssignableFrom(clazz)) {
            if(Connection.class.isAssignableFrom(clazz)) {
                if(OneToOneConnection.class.isAssignableFrom(clazz)) {
                    if (com.netcracker.edu.inventory.model.connection.entity.TwistedPair.class.isAssignableFrom(clazz))
                        return (T) new TwistedPair();
                    if (com.netcracker.edu.inventory.model.connection.entity.OpticFiber.class.isAssignableFrom(clazz))
                        return (T) new OpticFiber();
                }

                if(AllToAllConnection.class.isAssignableFrom(clazz)) {
                    if (com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial.class.isAssignableFrom(clazz))
                        return (T) new ThinCoaxial();
                }

                if(OneToManyConnection.class.isAssignableFrom(clazz)) {
                    if (com.netcracker.edu.inventory.model.connection.entity.Wireless.class.isAssignableFrom(clazz))
                        return (T) new Wireless();
                }

                if(ManyToManyConnection.class.isAssignableFrom(clazz)) {

                }
            } else if(Device.class.isAssignableFrom(clazz)) {
                if (com.netcracker.edu.inventory.model.device.entity.Battery.class.isAssignableFrom(clazz))
                    return (T) new Battery();
                if (com.netcracker.edu.inventory.model.device.entity.WifiRouter.class.isAssignableFrom(clazz))
                    return (T) new WifiRouter();
                if (com.netcracker.edu.inventory.model.device.entity.Switch.class.isAssignableFrom(clazz))
                    return (T) new Switch();
                if (com.netcracker.edu.inventory.model.device.entity.Router.class.isAssignableFrom(clazz))
                    return (T) new Router();
            }
        }
        IllegalArgumentException e = new IllegalArgumentException("Type is not instance of NetworkDevice.");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    @Override
    public <T extends Device> Rack<T> createEmptyRackImpl(String name, int size, Class<T> limitation) throws IllegalArgumentException {
        if(name != null) {
            if(RackArrayImpl.class.getSimpleName().equals(name)) return new RackArrayImpl(size, limitation);
        }
        IllegalArgumentException e = new IllegalArgumentException("name = null IllegalArgumentException");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    @Override
    public DevicePrimaryKey createDevicePrimaryKey(int inventoryNumber) throws IllegalArgumentException {
        return new DevicePK(inventoryNumber);
    }

    @Override
    public ConnectionPrimaryKey createConnectionPrimaryKey(Trunk trunk, int serialNumber) throws IllegalArgumentException {
        return new ConnectionPK(trunk, serialNumber);
    }

    @Override
    public RackPrimaryKey createRackPrimaryKey(Location location) throws IllegalArgumentException {
        return new RackPK(location);
    }

    @Override
    public <K extends Unique.PrimaryKey, T extends Unique<K>> T createLazyInstance(K primaryKey) {
        if(primaryKey instanceof DevicePrimaryKey)
            return (T) new DummyDevice((DevicePrimaryKey) primaryKey);
        if(primaryKey instanceof ConnectionPrimaryKey)
            return (T) new DummyConnection((ConnectionPrimaryKey) primaryKey);
        return null;
    }

    @Override
    public <T extends NetworkElement> T getImmutableNetworkElement(T original) throws IllegalArgumentException {
        if(original != null) {
            if (original instanceof Device) {
                DevicesImmutableWrapper devicesImmutableWrapper = new DevicesImmutableWrapper((Device) original);
                return getDeviceWrapper((Device) original, devicesImmutableWrapper);
            }
            if(original instanceof Connection) {
                ConnectionsImmutableWrapper connectionsImmutableWrapper = new ConnectionsImmutableWrapper((Connection) original);
                return getConnectionWrapper((Connection) original, connectionsImmutableWrapper);
            }
        }
        IllegalArgumentException e = new IllegalArgumentException("original is null");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    @Override
    public <D extends Device> Rack<D> getImmutableRack(Rack<D> original) throws IllegalArgumentException {
        if(original != null)
            return new RackImmutableWrapper<>(original);
        IllegalArgumentException e = new IllegalArgumentException("original is null");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    @Override
    public <T extends NetworkElement> T getSynchronizedNetworkElement(T original) throws IllegalArgumentException {
        if(original != null) {
            if (original instanceof Device) {
                DevicesSynchronizedWrapper devicesSynchronizedWrapper= new DevicesSynchronizedWrapper((Device) original);
                return getDeviceWrapper((Device) original, devicesSynchronizedWrapper);
            }
            if(original instanceof Connection) {
                ConnectionsSynchronizedWrapper connectionsSynchronizedWrapper = new ConnectionsSynchronizedWrapper((Connection) original);
                return getConnectionWrapper((Connection) original, connectionsSynchronizedWrapper);
            }
        }
        IllegalArgumentException e = new IllegalArgumentException("original is null");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    @Override
    public <D extends Device> Rack<D> getSynchronizedRack(Rack<D> original) throws IllegalArgumentException {
        if(original != null)
            return new RackSynchronizedWrapper(original);
        IllegalArgumentException e = new IllegalArgumentException("original is null");
        log.log(Level.SEVERE, e.getMessage(), e);
        throw e;
    }

    private <T extends NetworkElement> T getDeviceWrapper(Device device, AbstractDeviceWrapper abstractDeviceWrapper) {
        if(device instanceof com.netcracker.edu.inventory.model.device.entity.Battery) return (T) new BatteryWrapper(abstractDeviceWrapper);
        if(device instanceof com.netcracker.edu.inventory.model.device.entity.WifiRouter) return (T) new WifiRouterWrapper(abstractDeviceWrapper);
        if(device instanceof com.netcracker.edu.inventory.model.device.entity.Switch) return (T) new SwitchWrapper(abstractDeviceWrapper);
        if(device instanceof com.netcracker.edu.inventory.model.device.entity.Router) return (T) new RouterWrapper(abstractDeviceWrapper);
        return null;
    }

    private <T extends NetworkElement> T getConnectionWrapper(Connection connection, AbstractConnectionWrapper abstractConnectionWrapper) {
        if(connection instanceof com.netcracker.edu.inventory.model.connection.entity.OpticFiber) return (T) new OpticFiberWrapper(abstractConnectionWrapper);
        if(connection instanceof com.netcracker.edu.inventory.model.connection.entity.ThinCoaxial) return (T) new ThinCoaxialWrapper(abstractConnectionWrapper);
        if(connection instanceof com.netcracker.edu.inventory.model.connection.entity.TwistedPair) return (T) new TwistedPairWrapper(abstractConnectionWrapper);
        if(connection instanceof com.netcracker.edu.inventory.model.connection.entity.Wireless) return (T) new WirelessWrapper(abstractConnectionWrapper);
        return null;
    }
    @Override
    public <T extends NetworkElement> T subscribeTo(T original, PropertyChangeListener listener) throws IllegalArgumentException {
        check(original, listener);
        DevicesPublisherWrapper devicesPublisherWrapper = null;
        if(original instanceof Device) {
            if(original instanceof DeviceWrapper) {
                DeviceWrapper deviceWrapper = (DeviceWrapper) original;
                if(deviceWrapper.getAbstractDeviceWrapper() instanceof DevicesPublisherWrapper)
                    devicesPublisherWrapper = (DevicesPublisherWrapper) deviceWrapper.getAbstractDeviceWrapper();

            }
            else
                devicesPublisherWrapper = new DevicesPublisherWrapper((Device) original);
            if(devicesPublisherWrapper != null) {
                devicesPublisherWrapper.subscribe(listener);
                return (T) getDeviceWrapper((Device) original, devicesPublisherWrapper);
            }
        }
        if(original instanceof Connection) {
            ConnectionsPublisherWrapper connectionsPublisherWrapper = null;
            if(original instanceof ConnectionWrapper) {
                ConnectionWrapper connectionWrapper = (ConnectionWrapper) original;
                if(connectionWrapper.getAbstractConnectionWrapper() instanceof ConnectionsPublisherWrapper)
                    connectionsPublisherWrapper = (ConnectionsPublisherWrapper) connectionWrapper.getAbstractConnectionWrapper();

            }
            else
                connectionsPublisherWrapper = new ConnectionsPublisherWrapper((Connection) original);


            if(connectionsPublisherWrapper != null) {
                connectionsPublisherWrapper.subscribe(listener);
                return (T) getConnectionWrapper((Connection) original, connectionsPublisherWrapper);
            }
        }
        return null;
    }

    @Override
    public <D extends Device> Rack<D> subscribeTo(Rack<D> original, PropertyChangeListener listener) throws IllegalArgumentException {
        check(original, listener);
        return new RackPublisherWrapper(original).subscribe(listener);
    }

    @Override
    public boolean unsubscribeFrom(NetworkElement publisher, PropertyChangeListener listener) throws IllegalArgumentException {
        check(publisher, listener);
        if(publisher instanceof Device)
            return new DevicesPublisherWrapper((Device) publisher).unsubscribe(listener);
        if(publisher instanceof Connection)
            return new ConnectionsPublisherWrapper((Connection) publisher).unsubscribe(listener);
        return false;
    }

    @Override
    public boolean unsubscribeFrom(Rack publisher, PropertyChangeListener listener) throws IllegalArgumentException {
        check(publisher, listener);
        return new RackPublisherWrapper(publisher).unSubscribe(listener);
    }
    private void check(Object original, PropertyChangeListener listener) {
        if(original == null || listener == null) {
            IllegalArgumentException e = new IllegalArgumentException("Illegal Argument Exception");
            log.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
    }
}
