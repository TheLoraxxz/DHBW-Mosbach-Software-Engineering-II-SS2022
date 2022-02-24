package Lights;

public class LED {
    private boolean isOn;

    public LED() {
        this.isOn=false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
