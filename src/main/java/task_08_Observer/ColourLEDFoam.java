package task_08_Observer;

import Lights.LED;

public class ColourLEDFoam extends LED implements ISensorObserver{

    public ColourLEDFoam() {
        super();
        this.colType = ColourType.off;
        this.setOn(false);
    }

    public ColourType getColType() {
        return colType;
    }

    private ColourType colType;

    @Override
    public void showColour(ColourType color) {
        this.colType = color;
    }
}
