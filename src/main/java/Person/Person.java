package Person;

import Cabine.DoorFeeler;
import FLF.PositionType;

public abstract class Person {
    public void openBusDoor(PositionType position,DoorFeeler feeler) {
        feeler.press(this);
    }
}
