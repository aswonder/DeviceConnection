package ru.asdivov.test;

import ru.asdivov.test.devices.DisplayDevice;
import ru.asdivov.test.devices.SensorDevice;
import ru.asdivov.test.model.Devices;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isRuning = false;

        Devices devices = new Devices();
        devices.add(new SensorDevice());
        devices.add(new DisplayDevice());

        devices.connectDevices(devices.getOutputDevices().get(0), devices.getInputDevices().get(0));
        devices.runAll();

        devices.disconnectDevices(devices.getInputDevices().get(0));
        devices.runAll();

        devices.remove(devices.getInputDevices().get(0));
        devices.remove(devices.getOutputDevices().get(0));


        System.out.println("Enter command : ");
        while (isRuning) {

            System.out.print("#: ");
            String sCommand;

            Scanner scanIn = new Scanner(System.in);
            sCommand = scanIn.nextLine();
            //scanIn.close();

            switch (sCommand) {
                case "run":
                    //sensorDevice.run();
                    break;

                case "stop":
                    //sensorDevice.stop();
                    break;

                case "exit":
                    isRuning = false;
                    break;
            }

        }

    }
}
