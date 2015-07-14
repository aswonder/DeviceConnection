package ru.asdivov.test.model;

import ru.asdivov.test.model.interfaces.Device;

import java.util.Observable;

public abstract class OutputDevice extends Observable implements Device {

    private int i = 0;
    private boolean isRuning = false;

    public abstract void outlet();

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
        setChanged();
    }

    public void run(){
        isRuning = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                //while (isRuning) {
                    outlet();
                    notifyObservers();
                //}
            }
        }).run();
    }

    public void stop() {
        isRuning = false;
    }

    @Override
    public int getTypeDevice() {
        return Device.OUTPUT_DEVICE;
    }

}
