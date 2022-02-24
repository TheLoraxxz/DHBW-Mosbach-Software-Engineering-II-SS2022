package FLF;

import main.java.Driver.DriverSection;
import main.java.Engine.ElectricMotor;
import main.java.Engine.PivotStatic;
import main.java.Engine.PivotTurnable;
import main.java.ExtinguishDevices.FoamTank;
import main.java.ExtinguishDevices.FrontCannon;
import main.java.ExtinguishDevices.GroundSprayNozzles;
import main.java.ExtinguishDevices.HeadCannon;
import main.java.ExtinguishDevices.MixDevice;
import main.java.ExtinguishDevices.WaterTank;
import main.java.Joystick.GeneralJoystick;
import main.java.Lights.*;
import main.java.Operator.OperatorSection;
import main.java.Operator.SwitchType;

import java.util.HashMap;

public class CentralUnit {
    private HashMap<SwitchType, Lights[]> lights;
    private String Identifier = "DUS | FLF-5", Code = "6072";
    private String[] associatedPersonel;
    public ElectricMotor[] getMotors() {
        return motors;
    }

    private ElectricMotor[] motors;

    private BreakLight breakLight[];
    private TurnSignalLight turnSignalLight[];

    private PivotTurnable[] pivotsTurnable;
    private PivotStatic[] pivotsStatic;

    public MixDevice getMixer() {
        return mixer;
    }

    private MixDevice mixer;
    private FrontCannon frontCannon;
    private HeadCannon headCannon;

    private OperatorSection operatorSection;
    private DriverSection driverSection;



    private GroundSprayNozzles[] groundSprayNozzles;
    public CentralUnit(Box box,JoystickType type) {
        associatedPersonel = new String[]{"Red Adair", "Sam"};
        this.lights = new HashMap<>();
        this.lights.put(SwitchType.SideLights, new Lights[10]); //creating the ten side Lights
        this.lights.put(SwitchType.headLightsFront, new Lights[6]); // creating the 6 front lights
        this.lights.put(SwitchType.headLightsRoof, new Lights[4]); //4 roof lights roof
        this.lights.put(SwitchType.BlueLights, new Lights[10]);
        this.lights.put(SwitchType.warningLights, new Lights[2]);
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                this.lights.get(SwitchType.SideLights)[i] = new SideLight(PositionType.left); //5 on each side
            } else {
                this.lights.get(SwitchType.SideLights)[i] = new SideLight(PositionType.right);
            }
        }
        for (int i = 0; i < 6; i++) {
            if (i < 3) { //3 on each side
                this.lights.get(SwitchType.headLightsFront)[i] = new HeadLight(PositionType.frontleftbottom);
            } else {
                this.lights.get(SwitchType.headLightsFront)[i] = new HeadLight(PositionType.frontrightbottom);
            }
        }
        for (int i = 0; i < 4; i++) { // 4 on the top
            this.lights.get(SwitchType.headLightsRoof)[i] = new HeadLight(PositionType.frontop);
        }
        //the blue lights at the front
        this.lights.get(SwitchType.BlueLights)[0] = new BlueLight(PositionType.frontleftbottom, 1);
        this.lights.get(SwitchType.BlueLights)[1] = new BlueLight(PositionType.frontrightbottom, 1);
        //blue Lights at the top front left and right
        this.lights.get(SwitchType.BlueLights)[2] = new BlueLight(PositionType.fronlefttop, 4);
        this.lights.get(SwitchType.BlueLights)[3] = new BlueLight(PositionType.fronlefttop, 4);
        this.lights.get(SwitchType.BlueLights)[4] = new BlueLight(PositionType.frontrighttop, 4);
        this.lights.get(SwitchType.BlueLights)[5] = new BlueLight(PositionType.frontrighttop, 4);
        //bluelights at the back left and right
        this.lights.get(SwitchType.BlueLights)[6] = new BlueLight(PositionType.backrighttop, 2);
        this.lights.get(SwitchType.BlueLights)[7] = new BlueLight(PositionType.backrighttop, 2);
        this.lights.get(SwitchType.BlueLights)[8] = new BlueLight(PositionType.backlefttop, 2);
        this.lights.get(SwitchType.BlueLights)[9] = new BlueLight(PositionType.backlefttop, 2);
        //warning lights
        this.lights.get(SwitchType.warningLights)[0] = new WarningLight(PositionType.fronlefttop);
        this.lights.get(SwitchType.warningLights)[1] = new WarningLight(PositionType.backrighttop);
        //turnseignalLights
        this.turnSignalLight = new TurnSignalLight[]{
            new TurnSignalLight(PositionType.frontleftbottom),
            new TurnSignalLight(PositionType.frontrightbottom),
            new TurnSignalLight(PositionType.backleftbottom),
            new TurnSignalLight(PositionType.backrightbottom)
        };
        this.breakLight = new BreakLight[]{new BreakLight(PositionType.backleftbottom),new BreakLight(PositionType.backrightbottom)};
        // LIghts finished
        WaterTank tank1 = new WaterTank();
        FoamTank tank2 = new FoamTank();
        mixer = new MixDevice(tank1,tank2);
        frontCannon = new FrontCannon(mixer);
        headCannon = new HeadCannon(mixer);
        this.groundSprayNozzles = new GroundSprayNozzles[]{
            new GroundSprayNozzles(tank1),
            new GroundSprayNozzles(tank1),
            new GroundSprayNozzles(tank1),
            new GroundSprayNozzles(tank1),
            new GroundSprayNozzles(tank1),
            new GroundSprayNozzles(tank1),
            new GroundSprayNozzles(tank1)};
        
        this.motors = new ElectricMotor[]{new ElectricMotor(box),new ElectricMotor(box)};
        pivotsStatic = new PivotStatic[]{new PivotStatic(), new PivotStatic()};
        pivotsTurnable = new PivotTurnable[]{new PivotTurnable(), new PivotTurnable()};
        if(type==JoystickType.seperate) {
            driverSection = new DriverSection(this.turnSignalLight,pivotsTurnable,this.motors,frontCannon,breakLight,null);
            operatorSection = new OperatorSection(frontCannon, headCannon, lights, this.motors, mixer,null,groundSprayNozzles);
        } else {
            GeneralJoystick joystick = new GeneralJoystick(frontCannon,headCannon);
            driverSection = new DriverSection(this.turnSignalLight,pivotsTurnable,this.motors,frontCannon,breakLight,joystick);
            operatorSection = new OperatorSection(frontCannon, headCannon, lights, this.motors, mixer,joystick,groundSprayNozzles);
        }
        
    }

    public DriverSection getDriverSection() {
        return driverSection;
    }


    public OperatorSection getOperatorSection() {
        return operatorSection;
    }


    public HeadCannon getHeadCannon() {
        return headCannon;
    }

    public Lights[] getWarningLights() {
        return (Lights[]) this.lights.get(SwitchType.warningLights);
    }

    public Lights[] getHeadFrontLights() {
        return (Lights[]) this.lights.get(SwitchType.headLightsFront);
    }

    public Lights[] getHeadRoofLights() {
        return (Lights[]) this.lights.get(SwitchType.headLightsRoof);
    }

    public Lights[] getBlueLights() {
        return (Lights[]) this.lights.get(SwitchType.BlueLights);
    }

    public Lights[] getSideLights() {
        return (Lights[]) this.lights.get(SwitchType.SideLights);
    }

    public TurnSignalLight[] getTurnSignalLights() {
        return this.turnSignalLight;
    }

    public BreakLight[] getBreakLights() {
        return this.breakLight;
    }


    public FrontCannon getFrontCannon() {
        return frontCannon;
    }


    public PivotStatic[] getPivotsStatic() {
        return pivotsStatic;
    }


    public PivotTurnable[] getPivotsTurnable() {
        return pivotsTurnable;
    }

    public GroundSprayNozzles[] getGroundSprayNozzles() {
        return groundSprayNozzles;
    }

    public boolean CheckIDCode(String IDCode)
    {
        if(IDCode == Identifier+associatedPersonel[1]+Code || IDCode == Identifier+associatedPersonel[2]+Code)
        return true;
        return false;
    }
}
