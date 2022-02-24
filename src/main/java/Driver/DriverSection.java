package Driver;

import main.java.Engine.ElectricMotor;
import main.java.Engine.PivotTurnable;
import main.java.ExtinguishDevices.FrontCannon;
import main.java.FLF.PositionType;
import main.java.Joystick.GeneralJoystick;
import main.java.Joystick.Joystick;
import main.java.Lights.BreakLight;
import main.java.Lights.TurnSignalLight;
import main.java.Person.Driver;

public class DriverSection {
    private Driver driver;
    private GasPedal gasPedal;
    private PositionType relativePositionToControlPanel;
    private SteeringWheel steeringWheel;
    private BreakPedal breakPedal;
    private JoystickFrontCannon joystickFrontCannon;
    private GeneralJoystick joystick;

    public DriverSection(TurnSignalLight[] turnLight,PivotTurnable[] pivotTurnable,ElectricMotor[] motors,FrontCannon cannon,BreakLight[] breaklight,Joystick joystick) {
        relativePositionToControlPanel = PositionType.left;
        gasPedal = new GasPedal(pivotTurnable[0],motors);
        breakPedal = new BreakPedal(pivotTurnable[0],motors,breaklight);
        steeringWheel = new SteeringWheel(turnLight,pivotTurnable);
        if(joystick == null) {
            joystickFrontCannon = new JoystickFrontCannon(cannon);
        } else {
            this.joystick = (GeneralJoystick) joystick;
        }
        
    }
    public PositionType getPosition() {
        return this.relativePositionToControlPanel;
    }
    public void setDriver(Driver person) {
        this.driver = person;
    }
    public Driver getDriver() {
        return driver;
    }

    public GasPedal getGasPedal() {
        return gasPedal;
    }


    public BreakPedal getBreakPedal() {
        return breakPedal;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    public Joystick getJoystickFrontCannon() {
        if(joystickFrontCannon!=null) {
            return joystickFrontCannon;
        } else {
            return joystick;
        }
        
    }
}
