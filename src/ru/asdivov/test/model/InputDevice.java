package ru.asdivov.test.model;

import ru.asdivov.test.model.interfaces.Device;

import java.util.Observable;
import java.util.Observer;

public abstract class InputDevice implements Observer, Device {

    public abstract void processing(Observable o, Object arg);

    @Override
    public void update(Observable o, Object arg) {
        processing(o, arg);
    }

    @Override
    public int getTypeDevice() {
        return Device.INPUT_DEVICE;
    }
}
