package Cabine;


import Driver.DriverSection;
import Engine.Pivot;
import task_05_Adapter.Box;
import FLF.CentralUnit;
import FLF.PositionType;
import Operator.OperatorSection;

public class Cabin {

    public Cabin(DriverSection driver, OperatorSection operator, Box box, Pivot[] pivots, CentralUnit cUnit) {
        seats = new Seat[]{
            new Seat(PositionType.frontleft,driver),
            new Seat(PositionType.frontright,operator),
            new Seat(PositionType.backleft), 
            new Seat(PositionType.backright)};
        busDoors = new BusDoor[]{new BusDoor(PositionType.left,seats,cUnit),new BusDoor(PositionType.right,seats, cUnit)};
        energyDisplay = new EnergyDisplay(box);
        speedDisplay = new SpeedDisplay(pivots[0]);
    }

    public BusDoor[] getBusDoors() {
        return busDoors;
    }

    private final BusDoor[] busDoors;

    public Seat[] getSeats() {
        return seats;
    }

    private final Seat[] seats;

    public EnergyDisplay getEnergyDisplay() {
        return energyDisplay;
    }

    private final EnergyDisplay energyDisplay;

    public SpeedDisplay getSpeedDisplay() {
        return speedDisplay;
    }

    private final SpeedDisplay speedDisplay;

}
