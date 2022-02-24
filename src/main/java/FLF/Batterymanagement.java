package FLF;

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
    public void charge(int amount) {
        boxx.charge(amount);
    }
}
