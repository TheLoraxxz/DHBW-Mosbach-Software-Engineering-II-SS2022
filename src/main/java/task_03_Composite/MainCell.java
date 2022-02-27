package task_03_Composite;

public class MainCell extends Battery2{

    public MainCell(Battery2 battery2) {
        this.parentCell = battery2;
        this.subcells = new Battery2[100];
        for (int i =0;i<100;++i){
            this.subcells[i] = new Subcell(this);
        }
    }

    @Override
    public void charge(int amount) {
        for (Battery2 bat:subcells) {
            if (amount-10>0) {
                bat.charge(10);
                amount=amount-10;
            } else if (amount>0){
                bat.charge(amount);
                amount = 0;
            } else {
                bat.charge(0);
            }
        }
    }

    @Override
    public void takeOut(int amount) {
        for (Battery2 bat:subcells) {
            if (amount-10>0) {
                bat.takeOut(10);
                amount=amount-10;
            } else if (amount>0){
                bat.takeOut(amount);
                amount = 0;
            } else {
                bat.takeOut(0);
            }
        }
    }
}
