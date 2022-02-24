package Joystick;

public abstract class Joystick {
    protected JoyStickFeeler feeler;
    protected PressureButton[] buttons;

    public JoyStickFeeler getFeeler() {
        return this.feeler;
    }
    public PressureButton[] getPressureButtons() {
        return this.buttons;
    }
}
