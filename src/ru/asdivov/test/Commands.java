package ru.asdivov.test;

import ru.asdivov.test.devices.DisplayDevice;
import ru.asdivov.test.devices.SensorDevice;
import ru.asdivov.test.model.Devices;
import ru.asdivov.test.model.interfaces.Device;

import java.util.List;

public class Commands {

    public static void printDeviceList(List<Device> deviceList) {
        int i = 0;
        for (Device device : deviceList) {
            System.out.println("Dev# " + i++ + " " + device.toString());
        }
    }

    public static boolean execute(Devices devices, String command) {
        boolean result = true;

        if (command.contains("run")) {

            devices.runAll();

        } else if (command.contains("stop")) {

            devices.stopAll();

        } else if (command.contains("add")) {

            if (command.contains("in")) {

                devices.add(new DisplayDevice("Display " + String.valueOf(Math.round(Math.random() * 1000))));
                System.out.println("Input device added");

            } else if (command.contains("out")) {

                devices.add(new SensorDevice("Sensor " + String.valueOf(Math.round(Math.random() * 1000))));
                System.out.println("Output device added");
            }
            else {
                System.out.println("Use parameters: [in], [out]");
            }

        } else if (command.contains("list")) {

            if (command.contains("in")) {

                printDeviceList(devices.getInputDevices());

            } else if (command.contains("out")) {

                printDeviceList(devices.getOutputDevices());

            } else {

                printDeviceList(devices.getDevices());
            }

        } else if (command.contains("exit")) {

            result = false;

        } else {

            System.out.println("Command not found");

        }

        return result;
    }
}
