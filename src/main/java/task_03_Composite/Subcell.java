package task_03_Composite;

public class Subcell extends Battery {

    public Subcell(MainCell main) {
        this.parentCell = main;
        this.subcells = new Battery[10];
        for (int i =0;i<10;++i) {
            this.subcells[i] = new Cell(this);
        }
    }

    @Override
    public void charge(int amount) {
        for (Battery bat:subcells) {
            if (amount>0) {
                --amount;
                bat.charge(1);
            } else  {
                bat.charge(0);
            }
        }
    }

    @Override
    public void takeOut(int amount) {
        for (Battery bat:subcells) {
            if (amount>0) {
                --amount;
                bat.takeOut(1);
            } else  {
                bat.takeOut(0);
            }
        }
    }
}
