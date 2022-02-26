package Lights;

import FLF.PositionType;
import com.google.common.eventbus.Subscribe;
import task_02_SOA.WarningLightsEvent;

public class WarningLight extends Lights{
    private LED[] led;
    public WarningLight(PositionType pos) {
        super();
        this.position = pos;
        this.led = new LED[]{new LED()};
    }
    public LED[] getLeds() {
        return led;
    }


    @Subscribe
    public void recieve(WarningLightsEvent event) {
        if (isOn()) {
            off();
        } else {
            on();
        }
    }
}
