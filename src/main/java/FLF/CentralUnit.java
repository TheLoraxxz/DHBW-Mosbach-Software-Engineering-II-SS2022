package FLF;

import com.google.common.eventbus.EventBus;
import task_01_Components.MixDeviceCommunicator;
import task_02_SOA.*;
import task_05_Adapter.Box;
import Driver.DriverSection;
import Engine.ElectricMotor;
import Engine.PivotStatic;
import Engine.PivotTurnable;
import ExtinguishDevices.FoamTank;
import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.GroundSprayNozzles;
import ExtinguishDevices.HeadCannon;
import task_01_Components.MixDevice;
import ExtinguishDevices.WaterTank;
import Joystick.GeneralJoystick;
import Lights.*;
import Operator.OperatorSection;
import task_06_State.SwitchType;
import task_08_Observer.ColourLEDFoam;
import task_08_Observer.ColourLEDWater;
import task_09_visitor.ITestApplication;
import task_09_visitor.Testing;

import java.util.HashMap;

public class CentralUnit {
    private final HashMap<SwitchType, Lights[]> lights;
    private final String Identifier = "DUS | FLF-5";
    private final String Code = "6072";
    private final String[] associatedPersonel;
    public ElectricMotor[] getMotors() {
        return motors;
    }

    private final ElectricMotor[] motors;

    private final BreakLight[] breakLight;
    private final TurnSignalLight[] turnSignalLight;

    private final PivotTurnable[] pivotsTurnable;
    private final PivotStatic[] pivotsStatic;

    public MixDeviceCommunicator getMixer() {
        return mixer;
    }

    private final MixDeviceCommunicator mixer;
    private final FrontCannon frontCannon;
    private final HeadCannon headCannon;

    private final OperatorSection operatorSection;
    private final DriverSection driverSection;

    private final EventBus eventBus;



    private final GroundSprayNozzles[] groundSprayNozzles;
    public CentralUnit(Box box, JoystickType type) {
        this.eventBus = new EventBus();
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
        for (SwitchType key:this.lights.keySet()) {
            for (Lights lights:this.lights.get(key)) {
                eventBus.register(lights);
            }
        }

        //turnseignalLights
        this.turnSignalLight = new TurnSignalLight[]{
            new TurnSignalLight(PositionType.frontleftbottom),
            new TurnSignalLight(PositionType.frontrightbottom),
            new TurnSignalLight(PositionType.backleftbottom),
            new TurnSignalLight(PositionType.backrightbottom)
        };
        eventBus.register(this.turnSignalLight[0]);
        this.breakLight = new BreakLight[]{new BreakLight(PositionType.backleftbottom),new BreakLight(PositionType.backrightbottom)};
        eventBus.register(this.breakLight[0]);
        // LIghts finished
        ColourLEDFoam ledFoam = new ColourLEDFoam();
        ColourLEDWater ledWater = new ColourLEDWater();
        WaterTank tank1 = new WaterTank(ledWater);
        FoamTank tank2 = new FoamTank(ledFoam);
        mixer = new MixDeviceCommunicator(tank1,tank2);
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
        eventBus.register(groundSprayNozzles[0]);
        this.motors = new ElectricMotor[]{new ElectricMotor(box),new ElectricMotor(box)};
        eventBus.register(this.motors[0]);


        pivotsStatic = new PivotStatic[]{new PivotStatic(), new PivotStatic()};
        pivotsTurnable = new PivotTurnable[]{new PivotTurnable(), new PivotTurnable()};
        if(type==JoystickType.seperate) {
            driverSection = new DriverSection(this.turnSignalLight,pivotsTurnable,this.motors,frontCannon,breakLight,null);
            operatorSection = new OperatorSection(frontCannon, headCannon, null,this,ledFoam,ledWater);
        } else {
            GeneralJoystick joystick = new GeneralJoystick(frontCannon,headCannon);
            driverSection = new DriverSection(this.turnSignalLight,pivotsTurnable,this.motors,frontCannon,breakLight,joystick);
            operatorSection = new OperatorSection(frontCannon, headCannon,joystick,this,ledFoam,ledWater);
        }
    }

    public void changeLightState(SwitchType switchType) {
        switch (switchType) {
            case headLightsFront -> eventBus.post(new HeadLightsFrontEvent());
            case BlueLights -> eventBus.post(new BlueLightsEvent());
            case headLightsRoof -> eventBus.post(new HeadLightsRoofEvent());
            case SideLights -> eventBus.post(new SideLightsEvent());
            case warningLights -> eventBus.post(new WarningLightsEvent());
            default -> throw new RuntimeException();
        }
    }

    public void changeMotorState() {
        eventBus.post(new MotorEvent());
        //Routinetest
        ITestApplication test = new Testing();
        this.frontCannon.acceptTest(test);
    }
    public void changeGroundNozzleSpraysState() {
        eventBus.post(new GroundSprayNozzlesEvent());
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
        return this.lights.get(SwitchType.warningLights);
    }

    public Lights[] getHeadFrontLights() {
        return this.lights.get(SwitchType.headLightsFront);
    }

    public Lights[] getHeadRoofLights() {
        return this.lights.get(SwitchType.headLightsRoof);
    }

    public Lights[] getBlueLights() {
        return this.lights.get(SwitchType.BlueLights);
    }

    public Lights[] getSideLights() {
        return this.lights.get(SwitchType.SideLights);
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
        return IDCode == Identifier + associatedPersonel[1] + Code || IDCode == Identifier + associatedPersonel[2] + Code;
    }
}
