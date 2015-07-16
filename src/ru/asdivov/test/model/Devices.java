package ru.asdivov.test.model;

import ru.asdivov.test.model.interfaces.Device;

import java.util.*;

public class Devices {

    private List<Device> devices;
    private Map<InputDevice, OutputDevice> connectionMap;


    public Devices() {
        devices = new ArrayList<>();
        connectionMap = new HashMap<InputDevice, OutputDevice>();
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

    public Map<InputDevice, OutputDevice> getConnectionMap() {
        return connectionMap;
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
        outputDevice.addObserver(inputDevice);
        connectionMap.put(inputDevice, outputDevice);
    }


    public void disconnectDevices(Device device) {

        if (device.getTypeDevice() == Device.INPUT_DEVICE) {
            OutputDevice outputDevice = connectionMap.get(device);

            if (outputDevice != null) {
                outputDevice.deleteObserver((InputDevice) device);
                connectionMap.remove(device);
            }
        } else if (device.getTypeDevice() == Device.OUTPUT_DEVICE) {

            InputDevice inputDevice;
            for (Map.Entry<InputDevice, OutputDevice> entry : connectionMap.entrySet()) {
                if (device.equals(entry.getValue())) {
                    inputDevice = entry.getKey();
                    disconnectDevices(inputDevice);
                }
            }
        }
    }


}
