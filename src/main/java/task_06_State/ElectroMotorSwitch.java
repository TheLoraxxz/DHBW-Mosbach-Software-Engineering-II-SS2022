package task_06_State;

import FLF.CentralUnit;

public class ElectroMotorSwitch extends Switch{

    public ElectroMotorSwitch(CentralUnit unit) {
        super(SwitchType.electroMotor,unit);
    }

    @Override
    public void press() {
        System.out.println("test2");
        if(this.state instanceof OnState)
        {
            this.on.execute(this.switchTypeOperation);
        } else
        {
            this.off.execute(this.switchTypeOperation);
        }
    }
}
