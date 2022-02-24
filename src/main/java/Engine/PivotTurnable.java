package Engine;

public class PivotTurnable extends Pivot{
    private float turningValue; //positive = rechts --> negative = links
    public PivotTurnable() {
        this.turningValue = 0;
    }
    public float getTurningValue() {
        return turningValue;
    }

    public void setTurningValue(float turningValue) {
        this.turningValue = turningValue;
    }

}
