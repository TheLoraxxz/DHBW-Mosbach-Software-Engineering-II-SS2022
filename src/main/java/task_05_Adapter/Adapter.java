package task_05_Adapter;

public class Adapter extends Box implements IChargingStation{
    public Adapter() {
        super();
    }
    @Override
    public void chargStation(int amount) {
        int pole = amount /3;
        this.charge(pole,pole,pole);
    }
}
