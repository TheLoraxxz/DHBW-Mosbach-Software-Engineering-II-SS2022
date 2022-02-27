package Lights;

import FLF.PositionType;
import task_02_SOA.Subscriber;

public abstract class Lights extends Subscriber {
    protected PositionType position;


    private boolean isOn;
    Lights() {
        this.isOn = false;
    }
    public void on() {
        this.isOn = true;
    }

    public void off(){
        this.isOn = false;
    }


    public PositionType getPosition() {
        return position;
    }

    public boolean isOn() {
        return isOn;
    }
}
