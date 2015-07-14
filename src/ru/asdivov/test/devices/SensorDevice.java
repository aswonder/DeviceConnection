package ru.asdivov.test.devices;

import ru.asdivov.test.model.OutputDevice;

public class SensorDevice extends OutputDevice {

    @Override
    public void outlet() {
        setI((int) Math.round(Math.random() * 100));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
