package Operator;

import main.java.Lights.Lights;

import java.util.HashMap;

public class LightSwitch extends Switch {

    Lights[] lights;
    LightSwitch(SwitchType type, HashMap<SwitchType,Lights[]> lights) {
        super(type);
        this.lights = lights.get(type);
    }


    @Override
    public void on() {
        this.on = true;
        for (Lights t:lights) {
            t.on();
        }
    }

    @Override
    public void off() {
        this.on =false;
        for (Lights t:lights) {
            t.off();
        }
    }
}
