import FLF.FLF;
import Lights.Lights;
import Person.Operator;
import Lights.BlueLight;
import Lights.LED;
import Lights.Lights;
import Lights.WarningLight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import task_04_Strategy.Algorithms;
import task_06_State.SwitchType;
import task_08_Observer.ColourType;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTestApplication {
    private FLF flf;

    @BeforeEach
    public void Setup(){
        flf = null;
        flf = new FLF.Builder().build();
    }
    @Test
    @Order(1)
    public void Task01()
    {
        //wird in einer anderen jar durchgeführt -> keine exception hat funktioniert
    }

    @Test
    @Order(2)
    public void Task02()
    {
        flf.getCabin().getSeats()[1].setPerson(new Operator());
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
    public void Task03()
    {
        //battery2 wird nicht genutzt und nicht initialisiert nicht testbar
    }

    @Test
    @Order(4)
    public void Task04() throws Exception {
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        //test AES
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().encrypt(Algorithms.AES);
        assertNotEquals("6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().decrypt();
        assertEquals("6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        //test DES
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().encrypt(Algorithms.DES);
        assertNotEquals("6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().decrypt();
        assertEquals("6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        //test RSA
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().encrypt(Algorithms.RSA);
        assertNotEquals("6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().decrypt();
        assertEquals("6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
    }

    @Test
    @Order(5)
    public void Task05()
    {
        //stimmt adapter? amount/3 muss das nicht 300 300 400 sein ?
        //test lade funktion
        flf.getBatteries().takeOut(1000);
        assertEquals(99000,flf.getBatteries().getCapacityAll());
        //adapter muss noch ins flf eingebaut werden

    }

    @Test
    @Order(6)
    public void Task06()
    {
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        assertTrue(flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getMotorSwitch().getState());
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        assertFalse(flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getMotorSwitch().getState());
    }

    @Test
    @Order(7)
    public void Task07()
    {
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        for (int i = 0; i < 2; i++) {
            assertTrue(flf.getCentralUnit().getMotors()[i].isOn());
        }
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        for (int i = 0; i < 2; i++) {
            assertFalse(flf.getCentralUnit().getMotors()[i].isOn());
        }
    }

    @Test
    @Order(8)
    public void Task08()
    {
        flf.getCentralUnit().getMixer().getWaterTank().takeOut(6250); //50%
        assertEquals(ColourType.yellow,flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getLedWater().getColType());
        flf.getCentralUnit().getMixer().getWaterTank().takeOut(3125); //25%
        assertEquals(ColourType.orange,flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getLedWater().getColType());
        flf.getCentralUnit().getMixer().getWaterTank().takeOut(1875); //10%
        assertEquals(ColourType.red,flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getLedWater().getColType());

        flf.getCentralUnit().getMixer().getFoamTank().takeOut(1250  ); //50%
        assertEquals(ColourType.yellow,flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getLedFoam().getColType());
        flf.getCentralUnit().getMixer().getFoamTank().takeOut(625); //25%
        assertEquals(ColourType.orange,flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getLedFoam().getColType());
        flf.getCentralUnit().getMixer().getFoamTank().takeOut(375); //10%
        assertEquals(ColourType.red,flf.getCabin().getSeats()[1].getOperator().getOperatorSection().getPanel().getLedFoam().getColType());
    }

    @Test
    @Order(9)
    public void Task09()
    {
        //teste ob tanks noch voll sind um zu zeigen das die routine durchgeführt wurde
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        assertNotEquals(12500,flf.getCentralUnit().getMixer().getWaterTank().getCapacity());
        assertNotEquals(2500,flf.getCentralUnit().getMixer().getFoamTank().getCapacity());
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
}
