package Person;

import main.java.Cabine.DoorFeeler;
import main.java.FLF.PositionType;

public abstract class Person {
    public void openBusDoor(PositionType position,DoorFeeler feeler) {
        feeler.press(this);
    }
}
