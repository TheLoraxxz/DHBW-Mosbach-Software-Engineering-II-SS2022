package task_08_Observer;

import Lights.LED;

public class ColourLEDFoam extends LED implements ISensorObserver{

    public ColourType getColType() {
        return colType;
    }

    private ColourType colType;

    @Override
    public void showColour(ColourType color) {

    }
}
