package ru.asdivov.test;

import ru.asdivov.test.devices.DisplayDevice;
import ru.asdivov.test.devices.SensorDevice;
import ru.asdivov.test.model.Devices;
import ru.asdivov.test.model.interfaces.Device;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isRuning = true;

        Devices devices = new Devices();

        System.out.println("Enter commands : ");
        while (isRuning) {

            System.out.print("#: ");
            String sCommand;

            Scanner scanIn = new Scanner(System.in);
            sCommand = scanIn.nextLine();
            //scanIn.close();

            switch (sCommand) {
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
                    isRuning = false;
                    break;
            }

        }

    }
}
