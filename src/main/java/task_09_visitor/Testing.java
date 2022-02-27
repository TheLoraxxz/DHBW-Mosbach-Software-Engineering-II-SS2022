package task_09_visitor;

import ExtinguishDevices.*;
import task_01_Components.MixDevice;

public class Testing implements ITestApplication {

    @Override
    public boolean routine(GroundSprayNozzles type, WaterTank tank) {
        type.setCannonState(CannonState.active);
        int capacity =tank.getCapacity();
        type.pumpOut();
        type.setCannonState(CannonState.inactive);
        return capacity - tank.getCapacity() == 100;
    }

    @Override
    public boolean routine(FrontCannon type, MixDevice device) {
        int initCapacityWater = device.getWaterTank().getCapacity();
        int initCapacityFoam = device.getFoamTank().getCapacity();
        type.setCannonState(CannonState.active);
        if (type.getTiltDegree()!=90) {
            return false;
        }
        type.setSteps(FrontWaterStepsType.one);
        type.pumpOut();
        return device.getWaterTank().getCapacity() + 500 - initCapacityWater == 0 && initCapacityFoam == device.getFoamTank().getCapacity();
    }

    @Override
    public boolean routine(HeadCannon type,MixDevice device) {
        int initCapacityWater = device.getWaterTank().getCapacity();
        int initCapacityFoam = device.getFoamTank().getCapacity();
        type.setCannonState(CannonState.active);
        type.pumpOut();
        return initCapacityWater - device.getWaterTank().getCapacity() - 500 == 0 && initCapacityFoam == device.getFoamTank().getCapacity();
    }
}
