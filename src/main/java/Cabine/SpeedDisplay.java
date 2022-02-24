package Cabine;

import Engine.Pivot;

public class SpeedDisplay implements IDisplay{
    private Pivot pivot;
    public SpeedDisplay(Pivot pivot) {
        this.pivot = pivot;
    }
    @Override
    public String show() {
        
        return pivot.getSpeed()+"km/h";
    }
}
