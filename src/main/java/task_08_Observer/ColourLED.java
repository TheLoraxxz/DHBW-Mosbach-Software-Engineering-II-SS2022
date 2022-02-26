package task_08_Observer;

import FLF.PositionType;
import Lights.LED;

public class ColourLED extends LED implements ISensorObserver {
    private ColourType colType;
    private PositionType posType;

    public ColourLED(PositionType posType) {
        super();
        this.posType = posType;
        this.colType = null;
        this.setOn(false);
    }

    @Override
    public void showColour(ColourType color) {

    }
}
