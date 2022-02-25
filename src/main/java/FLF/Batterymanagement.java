package FLF;

import task_03_Composite.Battery;
import task_05_Adapter.Box;

public enum Batterymanagement {
    instance;
    Box boxx;
    Batterymanagement() {
        boxx = new Box();
    }
    public Battery[] getBatteries() {
        return boxx.getBatteries();
    }
    public void takeOut(int amount) {
        boxx.takeOut(amount);
    }
}
