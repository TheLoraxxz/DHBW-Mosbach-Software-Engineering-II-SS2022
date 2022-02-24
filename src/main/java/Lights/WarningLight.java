package Lights;

import FLF.PositionType;

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

}
