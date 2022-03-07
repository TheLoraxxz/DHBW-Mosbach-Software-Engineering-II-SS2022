package task_03_Composite;

public class Cell extends Battery {
    private boolean isEmpty;
    public Cell(Subcell parent) {
    parentCell =parent;
    isEmpty = false;
    }

    @Override
    public void charge(int amount) {
        if (amount==1) {
            this.isEmpty=false;
        } else {
            this.isEmpty = true;
        }
    }

    @Override
    public void takeOut(int amount) {
        if (amount==1) {
            this.isEmpty=true;
        } else {
            this.isEmpty=false;
        }
    }

    @Override
    public int getCapacity() {
        if (isEmpty) {
            return 0;
        } else {
            return 1;
        }
    }
}

