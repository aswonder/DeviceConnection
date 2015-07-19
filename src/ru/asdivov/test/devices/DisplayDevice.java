package ru.asdivov.test.devices;


import ru.asdivov.test.model.InputDevice;
import ru.asdivov.test.model.OutputDevice;

import java.util.Observable;

public class DisplayDevice extends InputDevice {

    public DisplayDevice(String name) {
        super(name);
    }

    @Override
    public void processing(Observable o, Object arg) {

        int i = ((OutputDevice) o).getI();

        //System.out.println(i);
        //  Debug
        System.out.println("Display # " + this.getName() + " | Message: " + i);
    }
}
