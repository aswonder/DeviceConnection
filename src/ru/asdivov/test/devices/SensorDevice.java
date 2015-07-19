package ru.asdivov.test.devices;

import ru.asdivov.test.model.OutputDevice;

public class SensorDevice extends OutputDevice {

    public SensorDevice(String name) {
        super(name);
    }

    @Override
    public void outlet() {
        //setI((int) Math.round(Math.random() * 100));
        //  Debug
        setI(Integer.parseInt(this.getName()));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
