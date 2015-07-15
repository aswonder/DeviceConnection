package ru.asdivov.test;

import ru.asdivov.test.devices.DisplayDevice;
import ru.asdivov.test.devices.SensorDevice;
import ru.asdivov.test.model.Devices;
import ru.asdivov.test.model.interfaces.Device;

public class Commands {

 public static boolean execute (Devices devices, String command) {
    boolean result = true;

     switch (command) {
         case "run":
             devices.runAll();
             break;

         case "stop":
             devices.stopAll();
             break;

         case "add in":
             devices.add(new DisplayDevice("Display " + String.valueOf(Math.round(Math.random()*1000))));
             break;

         case "add out":
             devices.add(new SensorDevice("Sensor " + String.valueOf(Math.round(Math.random()*1000))));
             break;

         case "list in": {
             int i = 0;
             for (Device device : devices.getInputDevices()) {
                 System.out.println("Dev# " + i++ + " | " + device.getName());
             }
             break;
         }

         case "list out": {
             int i = 0;
             for (Device device : devices.getOutputDevices()) {
                 System.out.println("Dev# " + i++ + " | " + device.getName());
             }
             break;
         }

         case "exit":
             result = false;
             break;
     }

     return result;
 }
}
