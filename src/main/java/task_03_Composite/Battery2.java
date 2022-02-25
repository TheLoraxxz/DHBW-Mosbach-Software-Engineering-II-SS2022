package task_03_Composite;

public abstract class Battery2 {
    protected Battery2 parentCell;
    protected Battery2[] subcells;

    Battery2() {
        parentCell = null;
        subcells = new Battery2[100];
        for (int i =0;i<100;++i){
            subcells[i] = new MainCell(this);
        }
    }
    public void charge(int amount) {
        for (Battery2 bat:subcells) {
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
        for (Battery2 bat:subcells) {
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
    protected int getCapacity() {
        int cap = 0;
        for (Battery2 bat: subcells) {
            cap=cap+bat.getCapacity();
        }
        return cap;
    }
}
