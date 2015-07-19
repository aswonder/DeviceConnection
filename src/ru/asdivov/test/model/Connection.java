package ru.asdivov.test.model;


import java.util.ArrayList;
import java.util.List;

public class Connection {

    private OutputDevice outputDevice;
    private List<InputDevice> inputDeviceList;

    public Connection(OutputDevice outputDevice, InputDevice inputDevice) {
        this.outputDevice = outputDevice;
        inputDeviceList = new ArrayList<InputDevice>();
        inputDeviceList.add(inputDevice);
    }

    public OutputDevice getOutputDevice() {
        return outputDevice;
    }

    public void setOutputDevice(OutputDevice outputDevice) {
        this.outputDevice = outputDevice;
    }

    public List<InputDevice> getInputDeviceList() {
        return inputDeviceList;
    }

    public void setInputDeviceList(List<InputDevice> inputDeviceList) {
        this.inputDeviceList = inputDeviceList;
    }

    public void add(InputDevice inputDevice) {
        inputDeviceList.add(inputDevice);
    }

    public void remove(InputDevice inputDevice) {
        inputDeviceList.remove(inputDevice);
    }

    @Override
    public String toString() {
        return outputDevice.toString() + " --> " + inputDeviceList.toString() + "\r\n";
    }

}
