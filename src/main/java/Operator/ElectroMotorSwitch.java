package Operator;

import Engine.ElectricMotor;

public class ElectroMotorSwitch extends Switch{
    private ElectricMotor[] motor;
    ElectroMotorSwitch(ElectricMotor[] motor) {
        super(SwitchType.electroMotor);
        this.motor = motor;
    }


    @Override
    public void on() {
        this.motor[0].setOn(true);
        this.motor[1].setOn(true);
        this.on = true;

    }

    @Override
    public void off() {
        this.motor[0].setOn(false);
        this.motor[1].setOn(false);
        this.on = false;
    }
}
