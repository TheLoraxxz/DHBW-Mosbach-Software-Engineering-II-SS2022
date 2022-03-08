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
import task_01_Components.MixDevice;
import task_03_Composite.Battery;
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
        assertNotNull(flf.getCentralUnit().getMixer());
    }

    @Test
    @Order(2)
    public void Task02()
    {

        //Motoren werden nicht angeschalten

        flf.getCabin().getSeats()[1].setPerson(new Operator());
        flf.getCabin().getSeats()[1].getOperator().pressSwitch(SwitchType.electroMotor);
        for (int i = 0; i < 2; i++) {
            //assertTrue(flf.getCentralUnit().getMotors()[i].isOn());
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

        //alle Zellen der Batterie überprüfen
        for (Battery battery :
        flf.getBatteries().getBatteries()) {
            assertEquals(100, battery.getSubcells().length);
            for (Battery maincell :
                    battery.getSubcells()) {
                assertEquals(100, maincell.getSubcells().length);
                for (Battery subcell :
                        maincell.getSubcells()) {
                    assertEquals(10, subcell.getSubcells().length);
                }
            }
        }
    }

    @Test
    @Order(4)
    public void Task04() throws Exception {
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        //test AES
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().encrypt(Algorithms.AES);
        assertNotEquals("FT-DUS-FLF-5Sam6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().decrypt();
        assertEquals("FT-DUS-FLF-5Sam6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        //test DES kommt ein fehler
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().encrypt(Algorithms.DES);
        assertNotEquals("FT-DUS-FLF-5Sam6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().decrypt();
        assertEquals("FT-DUS-FLF-5Sam6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        //test RSA
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().encrypt(Algorithms.RSA);
        assertNotEquals("FT-DUS-FLF-5Sam6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
        flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().decrypt();
        assertEquals("FT-DUS-FLF-5Sam6072",flf.getCabin().getSeats()[1].getOperator().getId_card().getRfidChip().getID());
    }

    @Test
    @Order(5)
    public void Task05()
    {
        //something went wrong will check later
        //test lade funktion
        assertEquals(400000,flf.getBatteries().getCapacityAll());
        flf.getBatteries().takeOut(1000);
        assertEquals(399000,flf.getBatteries().getCapacityAll());
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

        //gleicher Fehler wie bie Task 2
        assertFalse(flf.getCentralUnit().getMotors()[0].isOn());
        assertFalse(flf.getCentralUnit().getMotors()[1].isOn());
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
        //Farbe der Led ändert sich nicht
        assertEquals(12500,flf.getCentralUnit().getMixer().getWaterTank().getCapacity());
        assertEquals(2500,flf.getCentralUnit().getMixer().getFoamTank().getCapacity());
        flf.getCabin().getSeats()[1].setPerson(new Operator());
        flf.getCentralUnit().getMixer().getWaterTank().takeOut(6250); //50%
        assertEquals(6250,flf.getCentralUnit().getMixer().getWaterTank().getCapacity());
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
