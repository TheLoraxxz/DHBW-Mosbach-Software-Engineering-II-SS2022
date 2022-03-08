package task_03_Composite;

public class Batteries extends Battery{
    public Batteries() {
        parentCell = null;
        subcells = new Battery[100];
        for (int i =0;i<100;++i){
            subcells[i] = new MainCell(this);
        }
    }
}
