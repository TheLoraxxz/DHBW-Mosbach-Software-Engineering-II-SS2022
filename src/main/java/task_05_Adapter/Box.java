package task_05_Adapter;

import FLF.Status;
import task_03_Composite.Batteries;
import task_03_Composite.Battery;

public class Box {
    private Status batterystatus;
    private Battery[] batteries;
    public Box() {
        this.batteries = new Battery[]{new Batteries(),new Batteries(),new Batteries(),new Batteries()};
        this.batterystatus = Status.idle;
    }
    public void turnOn() {
        this.batterystatus = Status.use;
    }

    public void turnOf() {
        this.batterystatus = Status.idle;
    }

    public Status getStatus() {
        return this.batterystatus;
    }

    public void charge(int pole1,int pole2,int pole3) {
        int amount = pole1+pole2+pole3;
        for (Battery battery : batteries) {
            battery.charge(amount/4);
        }
    }

    public boolean takeOut(double amount) {
        int amountPerBat =(int) amount/4;
        for (Battery battery : batteries) {
            battery.takeOut(amountPerBat);
        }
        return true;
    }

    public double getCapacityAll() {
        double cap = 0;
        for (Battery battery : batteries) {
            cap = battery.getCapacity()+cap;
        }
        return cap;
    }
    public Battery[] getBatteries() {
        return batteries;
    }
}
