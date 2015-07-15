package ru.asdivov.test.model.interfaces;


public interface Device {

    public static final int INPUT_DEVICE = 0;
    public static final int OUTPUT_DEVICE = 1;
    public static final int INPUT_OUTPUT_DEVICE = 2;

    public int getTypeDevice();
    public String getName();

}
