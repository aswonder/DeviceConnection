package ru.asdivov.test;

import ru.asdivov.test.devices.DisplayDevice;
import ru.asdivov.test.devices.SensorDevice;
import ru.asdivov.test.model.Devices;
import ru.asdivov.test.model.interfaces.Device;

public class Commands {

 public static boolean execute (Devices devices, String command) {
    boolean result = true;

     if (command.contains("run")) {
         devices.runAll();
     }
     else if (command.contains("stop")) {
         devices.stopAll();
     }
     else if (command.contains("add")) {
         if (command.contains("in")) {
             devices.add(new DisplayDevice("Display " + String.valueOf(Math.round(Math.random()*1000))));
         }
         else if (command.contains("out")) {
             devices.add(new SensorDevice("Sensor " + String.valueOf(Math.round(Math.random()*1000))));
         }
     }
     else if (command.contains("list")) {
         if (command.contains("in")) {
             int i = 0;
             for (Device device : devices.getInputDevices()) {
                 System.out.println("Dev# " + i++ + " | " + device.getName());
             }
         }
         else if (command.contains("out")) {
             int i = 0;
             for (Device device : devices.getOutputDevices()) {
                 System.out.println("Dev# " + i++ + " | " + device.getName());
             }
         }
     }
     else if (command.contains("exit")) {
         result = false;
     }

     return result;
 }
}
