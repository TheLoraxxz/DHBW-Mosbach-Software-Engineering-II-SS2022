package Cabine;

import task_05_Adapter.Box;

public class EnergyDisplay implements IDisplay{

    private Box box;
    public EnergyDisplay(Box box) {
        this.box = box;
    }
    @Override
    public String show() {
        return box.getCapacityAll()+"/400000";
    }
}
