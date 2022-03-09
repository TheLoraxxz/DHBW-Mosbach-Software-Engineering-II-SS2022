package ExtinguishDevices;

public class PartSegments {
    private final int lenght;
    private int shownLength;
    public PartSegments(int lenght) {
        this.lenght = lenght;
        this.shownLength = 0;
    }
    public void moveOut() {
        this.shownLength = lenght;
    }
    public void moveIn() {
        this.shownLength =0;    
    }
    public int getShownLength() {
        return shownLength;
    }
}
