package ru.asdivov.test.model;

import ru.asdivov.test.model.interfaces.Device;

import java.util.*;

public class Devices {

    private List<Device> devices;
    private List<Connection> connectionList;


    public Devices() {
        devices = new ArrayList<>();
        connectionList = new ArrayList<Connection>();
    }


    public List<Device> getDevices() {
        List<Device> list = new ArrayList<>();
        for (Device device : devices) {
                list.add(device);
            }
        return list;
    }


    public List<Device> getInputDevices() {
        List<Device> list = new ArrayList<>();
        for (Device device : devices) {
            if (device.getTypeDevice() == Device.INPUT_DEVICE) {
                list.add((InputDevice) device);
            }
        }
        return list;
    }


    public List<Device> getOutputDevices() {
        List<Device> list = new ArrayList<>();
        for (Device device : devices) {
            if (device.getTypeDevice() == Device.OUTPUT_DEVICE) {
                list.add((OutputDevice) device);
            }
        }
        return list;
    }


    public List<Connection> getConnectionList() {
        return connectionList;
    }


    public void add(Device device) {
        devices.add(device);
    }


    public void remove(Device device) {
        disconnectDevices(device);
        if (devices.contains(device))
            devices.remove(device);
    }


    public void runAll() {
        for (Device device : getOutputDevices()) {
            OutputDevice deviceOut = (OutputDevice) device;
            deviceOut.run();
        }
    }


    public void stopAll() {
        for (Device device : getOutputDevices()) {
            OutputDevice deviceOut = (OutputDevice) device;
            deviceOut.stop();
        }
    }


    public void connectDevices(OutputDevice outputDevice, InputDevice inputDevice) {

        if (getIndexOfConnectedOutputDevice(outputDevice) != -1) {
            if (!connectionList.get(getIndexOfConnectedOutputDevice(outputDevice)).getInputDeviceList().contains(inputDevice))
            connectionList.get(getIndexOfConnectedOutputDevice(outputDevice)).add(inputDevice);
            outputDevice.addObserver(inputDevice);
        } else {
            connectionList.add(new Connection(outputDevice, inputDevice));
            outputDevice.addObserver(inputDevice);
        }
    }


    public void disconnectDevices(Device device) {

        if (device.getTypeDevice() == Device.INPUT_DEVICE) {

            List<Connection> listToDel = new ArrayList<Connection>();

            for (Connection connection: connectionList) {
                if (connection.getInputDeviceList().contains((InputDevice) device)) {
                    connection.getOutputDevice().deleteObserver((InputDevice) device);
                    connection.getInputDeviceList().remove((InputDevice) device);
                    if (connection.getInputDeviceList().size() == 0)
                        listToDel.add(connection);
                }
            }

            for (Connection connection: listToDel)
                connectionList.remove(connection);

        } else if (device.getTypeDevice() == Device.OUTPUT_DEVICE) {

            int index = getIndexOfConnectedOutputDevice((OutputDevice) device);
            List<InputDevice> list = connectionList.get(index).getInputDeviceList();

            for (InputDevice inputDevice: list) {
                ((OutputDevice) device).deleteObserver(inputDevice);
            }
            connectionList.remove(index);
        }
    }


    private int getIndexOfConnectedOutputDevice(OutputDevice outputDevice) {
        int result = -1;

        for (Connection connection: connectionList) {
            if (connection.getOutputDevice().equals(outputDevice))
                result = connectionList.indexOf(connection);
        }

        return result;
    }

}
