package task_09_visitor;

import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.GroundSprayNozzles;
import ExtinguishDevices.HeadCannon;
import ExtinguishDevices.WaterTank;
import task_01_Components.MixDeviceCommunicator;

public interface ITestApplication {
    public boolean routine(GroundSprayNozzles type, WaterTank tank);
    public boolean routine(FrontCannon type, MixDeviceCommunicator device);
    public boolean routine(HeadCannon type, MixDeviceCommunicator device);
}
