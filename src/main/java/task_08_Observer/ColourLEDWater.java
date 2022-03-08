package task_08_Observer;

import FLF.PositionType;
import Lights.LED;

public class ColourLEDWater extends LED implements ISensorObserver {
    public ColourType getColType() {
        return colType;
    }

    private ColourType colType;

    public ColourLEDWater() {
        super();
        this.colType = null;
        this.setOn(false);
    }

    @Override
    public void showColour(ColourType color) {

    }
}
