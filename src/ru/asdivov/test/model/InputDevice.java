package ru.asdivov.test.model;

import ru.asdivov.test.model.interfaces.Device;

import java.util.Observable;
import java.util.Observer;

public abstract class InputDevice implements Observer, Device {

    private String name;

    public abstract void processing(Observable o, Object arg);

    public InputDevice(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " | Type: " + getTypeDevice() ;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void update(Observable o, Object arg) {
        processing(o, arg);
    }

    @Override
    public int getTypeDevice() {
        return Device.INPUT_DEVICE;
    }
}
