package task_08_Observer;

import java.util.ArrayList;

public class Sensor {
    private ISensorObserver led;

    public Sensor() {

    }

    public void moreThan50() {
        led.showColour(null);
    }

    public void lessThan50() {
        led.showColour(ColourType.yellow);

    }

    public void lessThan25() {
        led.showColour(ColourType.orange);

    }
    public void lessThan10() {
        led.showColour(ColourType.red);

    }
}
