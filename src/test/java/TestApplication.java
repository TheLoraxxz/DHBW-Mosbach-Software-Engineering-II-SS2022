import FLF.FLF;
import Cabine.BusDoor;
import Cabine.Seat;
import Engine.Pivot;
import ExtinguishDevices.CannonState;
import ExtinguishDevices.FrontWaterStepsType;
import ExtinguishDevices.KnopRoofStepsType;
import Lights.BlueLight;
import Lights.LED;
import Lights.Lights;
import Lights.WarningLight;
import task_06_State.LightSwitch;
import task_06_State.SwitchType;
import Person.Driver;
import Person.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestApplication {
    private FLF flf;

    @BeforeEach
    public void Setup(){
        flf = null;
        flf = new FLF.Builder().build();
    }
    
    @Test
    @Order(1)
    public void buildComplete()
    {
        //flfS
        assertNotNull(flf.getCabin());
        assertNotNull(flf.getCentralUnit());
        assertNotNull(flf.getBatteries());
        assertEquals(4,flf.getBatteries().getBatteries().length);
        //Cabine
        assertEquals(4,flf.getCabin().getSeats().length);
        for (Seat s:flf.getCabin().getSeats()) {
            assertNotNull(s.getRespirators());
        }
        assertEquals(2,flf.getCabin().getBusDoors().length);
        assertNotNull(flf.getCabin().getEnergyDisplay());
        assertNotNull(flf.getCabin().getSpeedDisplay());
        for (BusDoor b:flf.getCabin().getBusDoors()) {
            assertEquals(2,b.getDoorFeelers().length);
        }
        //central unit
        //lights
        assertEquals(2,flf.getCentralUnit().getWarningLights().length);
        assertEquals(6,flf.getCentralUnit().getHeadFrontLights().length);
        assertEquals(4,flf.getCentralUnit().getHeadRoofLights().length);
        assertEquals(10,flf.getCentralUnit().getSideLights().length);
           assertEquals(10,flf.getCentralUnit().getBlueLights().length);
            for(int i =0; i < 10;i++)
            {
                if (flf.getCentralUnit().getBlueLights()[i] instanceof BlueLight)
                 switch(i){
                    case 0:
                    case 1:assertEquals(1,((BlueLight)flf.getCentralUnit().getBlueLights()[i]).getLeds().length);break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:assertEquals(4,((BlueLight)flf.getCentralUnit().getBlueLights()[i]).getLeds().length);break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:assertEquals(2,((BlueLight)flf.getCentralUnit().getBlueLights()[i]).getLeds().length);break;
            }
        }
        assertEquals(4,flf.getCentralUnit().getTurnSignalLights().length);
        assertEquals(2,flf.getCentralUnit().getBreakLights().length);

        //Cannons
        assertNotNull(flf.getCentralUnit().getFrontCannon());
        assertNotNull(flf.getCentralUnit().getHeadCannon());
        //pivots
        assertEquals(2,flf.getCentralUnit().getPivotsStatic().length);
        assertEquals(2,flf.getCentralUnit().getPivotsTurnable().length);
        for (Pivot p:flf.getCentralUnit().getPivotsStatic()) {
            assertEquals(6,p.getBreakDisks().length);
            assertEquals(2,p.getWheels().length);
        }
        //driverSection
        assertNotNull(flf.getCentralUnit().getDriverSection());
        assertNotNull(flf.getCentralUnit().getDriverSection().getBreakPedal());
        assertNotNull(flf.getCentralUnit().getDriverSection().getGasPedal());
        assertNotNull(flf.getCentralUnit().getDriverSection().getSteeringWheel());
        assertNotNull(flf.getCentralUnit().getDriverSection().getJoystickFrontCannon());
        //operatorSection
        assertNotNull(flf.getCentralUnit().getOperatorSection());
        assertNotNull(flf.getCentralUnit().getOperatorSection().getPanel());
        for (LightSwitch s:flf.getCentralUnit().getOperatorSection().getPanel().getSwitches()) {
            assertNotNull(s);
        }
        assertNotNull(flf.getCentralUnit().getOperatorSection().getPanel().getKnobRoof());
        assertNotNull(flf.getCentralUnit().getOperatorSection().getPanel());
    }
    @Test
    @Order(2)
    public void usageControlPanel()
    {
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        System.out.println(flf.getCentralUnit().getMotors()[1].isOn());
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        for (int i = 0; i < 2; i++) {
            assertTrue(flf.getCentralUnit().getMotors()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        for (int i = 0; i < 2; i++) {
            assertFalse(flf.getCentralUnit().getMotors()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.warningLights);
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.BlueLights);
        CheckLED(true);
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.warningLights);
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.BlueLights);
        CheckLED(false);
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.headLightsFront);
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            assertTrue(flf.getCentralUnit().getHeadFrontLights()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.headLightsFront);
        for (int i = 0; i < 2; i++) {
            assertFalse(flf.getCentralUnit().getHeadFrontLights()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.headLightsRoof);
        for (int i = 0; i < 2; i++) {
            assertTrue(flf.getCentralUnit().getHeadRoofLights()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.headLightsRoof);
        for (int i = 0; i < 2; i++) {
            assertFalse(flf.getCentralUnit().getHeadRoofLights()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.SideLights);
        for (int i = 0; i < 2; i++) {
            assertTrue(flf.getCentralUnit().getSideLights()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.SideLights);
        for (int i = 0; i < 2; i++) {
            assertFalse(flf.getCentralUnit().getSideLights()[i].isOn());
        }
    }
    @Test
    @Order(3)
    public void handleParking()
    {
        flf.getCentralUnit().getMotors()[0].setOn(false);
        flf.getCentralUnit().getMotors()[1].setOn(false);
        for (int i = 0; i < 2; i++) {
            assertFalse(flf.getCentralUnit().getMotors()[i].isOn());   
        }
        for (int i = 0; i < 4; i++) {
            assertFalse(flf.getCabin().getSeats()[i].isTaken());
        }
        for (int i = 0; i < 2; i++) {
            assertFalse(flf.getCabin().getBusDoors()[i].isOpen());
        }
        assertEquals(CannonState.inactive,flf.getCentralUnit().getFrontCannon().getCannonState());
        assertEquals(CannonState.inactive,flf.getCentralUnit().getHeadCannon().getCannonState());
        for (Lights l:
                flf.getCentralUnit().getHeadRoofLights()) {
                l.off();
            assertFalse(l.isOn());
        }
        for (Lights l:
                flf.getCentralUnit().getSideLights()) {
            l.off();
            assertFalse(l.isOn());
        }
        for (Lights l:
                flf.getCentralUnit().getHeadFrontLights()) {
            l.off();
            assertFalse(l.isOn());
        }
        CheckLED(false);
        CheckTanks();
        flf.getBatteries();
        ChargeBatterie();
        CheckEnergyConsumption(400000);
        assertEquals(KnopRoofStepsType.a,flf.getCentralUnit().getHeadCannon().getSteps());
        assertEquals(FrontWaterStepsType.one,flf.getCentralUnit().getFrontCannon().getSteps());
    }
    @Test
    @Order(4)
    public void handleInspectionDrive()
    {
        StartFLF();
        ChargeBatterie();
        CheckLightOff(false);
        CheckTanks();
        ChangeKnopsToOne();
        Accelerate(7);
        Drive(5);
        SteerTO(-5);
        Drive(3);
        SteerTO(5);
        Drive(5);
        SteerTO(5);
        Drive(5);
        Break(7);
        CheckEnergyConsumption(376800);
    }
    @Test
    @Order(5)
    public void handleEmergencyService()
    {
        StartFLF();
        CheckLightOff(true);
        CheckTanks();
        ChangeKnopsToOne();
        Accelerate(20);
        Drive(10);
        CheckEnergyConsumption(358960);
    }
    @Test
    @Order(6)
    public void handleFuelTruckOnFire()
    {
        StartFLF();
        CheckLightsOn();
        CheckTanks();
        //bitte ändern
        //flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getNozzleSwitch().on();
        //flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getNozzleSwitch().off();
        CheckWaterConsumption(100550);
        ChangeFrontCannonState(3,FrontWaterStepsType.six,2);
        CheckWaterConsumption(92000);
        CheckFoamConsumption(33300);
        ChangeHeadCannonState(3,KnopRoofStepsType.c,1);
        CheckWaterConsumption(85250);
        CheckFoamConsumption(32550);
    }
    @Test
    @Order(7)
    public void handlePushbackVehicleOnFire()
    {
        StartFLF();
        CheckLightsOn();
        CheckTanks();
        ChangeFrontCannonState(3,FrontWaterStepsType.seven,3);
        CheckWaterConsumption(91800);
        CheckFoamConsumption(32700);
        ChangeHeadCannonState(5,KnopRoofStepsType.c,1);
        CheckWaterConsumption(79300);
        CheckFoamConsumption(32700);
        ChangeFrontCannonState(3,FrontWaterStepsType.two,1);
        CheckWaterConsumption(76390);
        CheckFoamConsumption(32610);
    }
    @Test
    @Order(8)
    public void handleAirplaneEngineFire()
    {
        StartFLF();
        CheckLightsOn();
        CheckTanks();
        ChangeFrontCannonState(5,FrontWaterStepsType.seven,3);
        CheckWaterConsumption(85500);
        CheckFoamConsumption(32000);
        ChangeHeadCannonState(5,KnopRoofStepsType.c,3);
        CheckWaterConsumption(73625);
        CheckFoamConsumption(31375);
        ChangeHeadCannonState(5,KnopRoofStepsType.c,3);
        CheckWaterConsumption(61500);
        CheckFoamConsumption(31000);
        ChangeFrontCannonState(5,FrontWaterStepsType.seven,3);
        CheckWaterConsumption(44000);
        CheckFoamConsumption(31000);
    }

    public void StartFLF()
    {
        flf.getCentralUnit().getMotors()[0].setOn(true);
        flf.getCentralUnit().getMotors()[1].setOn(true);
        for (int i = 0; i < 2; i++)
        {
            assertTrue(flf.getCentralUnit().getMotors()[i].isOn());
        }
        flf.getCabin().getSeats()[0].setPerson(new Driver());
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        for (int i = 0; i < 2; i++)
        {
            assertTrue(flf.getCabin().getSeats()[i].isTaken());
        }
        for (int i = 0; i < 2; i++)
        {
            assertFalse(flf.getCabin().getBusDoors()[i].isOpen());
        }
    }

    public void CheckLightOff(boolean HeadlightValue)
    {
        assertEquals(CannonState.inactive,flf.getCentralUnit().getFrontCannon().getCannonState());
        assertEquals(CannonState.inactive,flf.getCentralUnit().getHeadCannon().getCannonState());
        for (Lights l:
                flf.getCentralUnit().getHeadRoofLights()) {
            if (HeadlightValue)
                l.on();
            else
                l.off();
            assertEquals(HeadlightValue,l.isOn());
        }
        for (Lights l:
                flf.getCentralUnit().getSideLights()) {
            l.off();
            assertFalse(l.isOn());
        }
        for (Lights l:
                flf.getCentralUnit().getHeadFrontLights()) {
            l.on();
            assertTrue(l.isOn());
        }
        CheckLED(true);
    }

    public void CheckLightsOn()
    {
        for (Lights l:
             flf.getCentralUnit().getHeadRoofLights()) {
            l.on();
            assertTrue(l.isOn());
        }
        for (Lights l:
                flf.getCentralUnit().getSideLights()) {
            l.on();
            assertTrue(l.isOn());
        }
        for (Lights l:
                flf.getCentralUnit().getHeadFrontLights()) {
            l.on();
            assertTrue(l.isOn());
        }
        CheckLED(true);
    }
    
    public void CheckLED(boolean checkValue)
    {
        for (Lights l:
                flf.getCentralUnit().getWarningLights()) {
            WarningLight wl = (WarningLight) l;
            for (LED led:
                 wl.getLeds()) {
                led.setOn(checkValue);
                assertEquals(checkValue,led.isOn());
            }
        }
        for (Lights l:
                flf.getCentralUnit().getBlueLights()) {
            BlueLight wl = (BlueLight) l;
            for (LED led:
                    wl.getLeds()) {
                led.setOn(checkValue);
                assertEquals(checkValue,led.isOn());
            }
        }
    }

    public void CheckTanks()
    {
       assertEquals(101250,flf.getCentralUnit().getMixer().getWaterTank().getCapacity());
        assertEquals(33750,flf.getCentralUnit().getMixer().getFoamTank().getCapacity());
    }

    public void ChangeKnopsToOne()
    {
        flf.getCabin().getSeats()[1].getOperator().changeFrontKnobToType(FrontWaterStepsType.one);
        flf.getCabin().getSeats()[1].getOperator().changeHeadKnobToType(KnopRoofStepsType.a);
        assertEquals(KnopRoofStepsType.a,flf.getCentralUnit().getHeadCannon().getSteps());
        assertEquals(FrontWaterStepsType.one,flf.getCentralUnit().getFrontCannon().getSteps());
    }

    public void Accelerate(int iterations)
    {
        for (int i=0; i < iterations;i++)
            flf.getCabin().getSeats()[0].getDriver().pressGasPedal();
    }

    public void Drive(int iterations)
    {
        for (int i=0; i < iterations;i++)
            flf.getCabin().getSeats()[0].getDriver().releaseGasPedal();
    }

    public void SteerTO(int degree)
    {
        flf.getCabin().getSeats()[0].getDriver().turnWheel(degree);
        assertEquals(degree,flf.getCabin().getSeats()[0].getDriver().getSection().getSteeringWheel().getTurnables()[0].getTurningValue());
    }

    public void Break(int iterations)
    {
        for (int i=0; i < iterations;i++)
            flf.getCabin().getSeats()[0].getDriver().pressGasPedal();
    }

    public void CheckEnergyConsumption(int CorrectValue)
    {
        assertEquals(CorrectValue,flf.getBatteries().getCapacityAll());
    }

    public void CheckWaterConsumption(int CorrectValue)
    {
        assertEquals(CorrectValue,flf.getCentralUnit().getMixer().getWaterTank().getCapacity());
    }

    public void CheckFoamConsumption(int CorrectValue)
    {
        assertEquals(CorrectValue,flf.getCentralUnit().getMixer().getFoamTank().getCapacity());
    }

    public void ChangeFrontCannonState(int iterations, FrontWaterStepsType targetType, int mixValue)
    {
        if(flf.getCentralUnit().getFrontCannon().getTiltDegree() != 90)
            flf.getCabin().getSeats()[0].getDriver().pressJoystickLeft();
        flf.getCabin().getSeats()[1].getOperator().changeFrontKnobToType(targetType);
        for (int i = 0; i < mixValue; i++)
        {
            flf.getCabin().getSeats()[0].getDriver().pressJoystickRight();
        }
        for (int i = 0; i < iterations; i++)
        {
            flf.getCabin().getSeats()[0].getDriver().pressFeeler();
        }
    }

    public void ChangeHeadCannonState(int iterations, KnopRoofStepsType targetType, int mixValue)
    {
        if(!flf.getCentralUnit().getHeadCannon().isMovedOut())
            flf.getCabin().getSeats()[1].getOperator().pressJoystickLeft();
        flf.getCabin().getSeats()[1].getOperator().changeHeadKnobToType(targetType);
        for (int i = 0; i < mixValue; i++)
        {
            flf.getCabin().getSeats()[1].getOperator().pressJoystickRight();
        }
        for (int i = 0; i < iterations; i++)
        {
            flf.getCabin().getSeats()[1].getOperator().pressFeeler();
        }
    }

    private void ChargeBatterie()
    {

    }
}
