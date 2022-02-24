package Lights;

import main.java.FLF.PositionType;

public abstract class Lights {
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
