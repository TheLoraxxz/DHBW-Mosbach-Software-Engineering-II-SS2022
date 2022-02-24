package Driver;

import Engine.ElectricMotor;
import Engine.Pivot;

public class GasPedal implements IPedal{

    private Pivot pivot;
    private ElectricMotor[] motors;

    public GasPedal(Pivot pivot, ElectricMotor[] motors) {
        this.motors = motors;
        this.pivot = pivot;
    }
    @Override
    public void press() {
        this.pivot.setSpeed(this.pivot.getSpeed()+4);
        this.motors[0].changeSpeed(this.pivot.getSpeed());
        this.motors[1].changeSpeed(this.pivot.getSpeed());
    }
    @Override
    public void release() { 
        this.motors[0].changeSpeed(this.pivot.getSpeed());
        this.motors[1].changeSpeed(this.pivot.getSpeed());       
    }
}
