package task_05_Adapter;

public class ChargingStation implements IChargingStation{
    private final Adapter adapter;
    public ChargingStation(Adapter adapter) {
        this.adapter=adapter;
    }

    @Override
    public void chargStation(int amount) {
        adapter.chargStation(amount);
    }
}
