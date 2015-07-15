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

            isRuning = Commands.execute(devices, sCommand);

        }
    }
}
