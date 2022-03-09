package task_03_Composite;

public class Cell extends Battery {
    private boolean isEmpty;
    public Cell(Subcell parent) {
    parentCell =parent;
    isEmpty = false;
    }

    @Override
    public void charge(int amount) {
        this.isEmpty= amount != 1;
    }

    @Override
    public void takeOut(int amount) {
        this.isEmpty= amount == 1;
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

