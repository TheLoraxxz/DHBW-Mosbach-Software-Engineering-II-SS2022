package task_03_Composite;

public abstract class Battery {
    protected Battery parentCell;
    protected Battery[] subcells;

    public void charge(int amount) {
        for (Battery bat:subcells) {
            if (amount-1000>0) {
                bat.charge(1000);
                amount=amount-1000;
            } else if (amount>0){
                bat.charge(amount);
                amount = 0;
            } else {
                bat.charge(0);
            }
        }
    }

    public void takeOut(int amount) {
        for (Battery bat:subcells) {
            if (amount-1000>0) {
                bat.takeOut(1000);
                amount=amount-1000;
            } else if (amount>0){
                bat.takeOut(amount);
                amount = 0;
            } else {
                bat.takeOut(0);
            }
        }
    }
    public int getCapacity() {
        int cap = 0;
        for (Battery bat: subcells) {
            cap=cap+bat.getCapacity();
        }
        return cap;
    }
}
