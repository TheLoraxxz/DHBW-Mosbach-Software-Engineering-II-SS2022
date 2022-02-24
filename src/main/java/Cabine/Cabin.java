package Cabine;


import main.java.Driver.DriverSection;
import main.java.Engine.Pivot;
import main.java.FLF.Box;
import main.java.FLF.CentralUnit;
import main.java.FLF.PositionType;
import main.java.Operator.OperatorSection;

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

    private BusDoor[] busDoors;

    public Seat[] getSeats() {
        return seats;
    }

    private Seat[] seats;

    public EnergyDisplay getEnergyDisplay() {
        return energyDisplay;
    }

    private EnergyDisplay energyDisplay;

    public SpeedDisplay getSpeedDisplay() {
        return speedDisplay;
    }

    private SpeedDisplay speedDisplay;

}
