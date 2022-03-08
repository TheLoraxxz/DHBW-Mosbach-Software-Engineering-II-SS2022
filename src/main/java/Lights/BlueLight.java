package Lights;

import FLF.PositionType;
import com.google.common.eventbus.Subscribe;
import task_02_SOA.BlueLightsEvent;

public class BlueLight extends Lights{
    private LED[] leds;

    public BlueLight(PositionType pos, int ledNumber) {
        super();
        this.position = pos;
        this.leds = new LED[ledNumber];
        initLeds(ledNumber);
    }

    private void initLeds(int ledNumber)
    {
        for (int i = 0;  i< ledNumber;i++)
        {
            leds[i] = new LED();
        }
    }
    public LED[] getLeds() {
        return leds;
    }

    @Override
    public void on() {
        for (LED led:
             leds) {
            led.setOn(true);
        }
        super.on();
    }

    @Override
    public void off() {
        for (LED led:
                leds) {
            led.setOn(false);
        }
        super.off();
    }

    @Subscribe
    public void recieving(BlueLightsEvent event) {
        System.out.println("recieve Blueligght");
        if (this.isOn()) {
            off();
        } else {
            on();
        }
    }
}
