package ru.asdivov.test.model;

import ru.asdivov.test.model.interfaces.Device;

import java.util.*;

public class Devices {

    private List<InputDevice> inputDevices;
    private List<OutputDevice> outputDevices;
    private Map<InputDevice, OutputDevice> connectionMap;

    public List<InputDevice> getInputDevices() {
        return inputDevices;
    }


    public List<OutputDevice> getOutputDevices() {
        return outputDevices;
    }


    public Map<InputDevice, OutputDevice> getConnectionMap() {
        return connectionMap;
    }


    public Devices() {
        inputDevices = new ArrayList<InputDevice>();
        outputDevices = new ArrayList<OutputDevice>();
        connectionMap = new HashMap<InputDevice, OutputDevice>();
    }


    public void add(Device device) {
        switch (device.getTypeDevice()) {
            case Device.INPUT_DEVICE:
                inputDevices.add((InputDevice) device);
                break;
            case Device.OUTPUT_DEVICE:
                outputDevices.add((OutputDevice) device);
                break;
        }
    }


    public void remove(Device device) {
        switch (device.getTypeDevice()) {
            case Device.INPUT_DEVICE:
                disconnectDevices((InputDevice) device);
                inputDevices.remove((InputDevice) device);
                break;
            case Device.OUTPUT_DEVICE:
                disconnectDevices((OutputDevice) device);
                outputDevices.remove((OutputDevice) device);
                break;
        }
    }


    public void runAll() {
        for(OutputDevice device : outputDevices) {
            device.run();
        }
    }


    public void stopAll() {
        for(OutputDevice device : outputDevices) {
            device.stop();
        }
    }


    public void connectDevices (OutputDevice outputDevice, InputDevice inputDevice) {
        outputDevice.addObserver(inputDevice);
        connectionMap.put(inputDevice, outputDevice);
    }


    public void disconnectDevices (InputDevice inputDevice) {
        OutputDevice outputDevice = connectionMap.get(inputDevice);

        if (outputDevice != null) {
            outputDevice.deleteObserver(inputDevice);
            connectionMap.remove(inputDevice);
        }
    }


    public void disconnectDevices (OutputDevice outputDevice) {
        InputDevice inputDevice;

        for (Map.Entry<InputDevice, OutputDevice> entry : connectionMap.entrySet()) {
            if (outputDevice.equals(entry.getValue())) {
                inputDevice = entry.getKey();
                disconnectDevices(inputDevice);
            }
        }
    }


}
