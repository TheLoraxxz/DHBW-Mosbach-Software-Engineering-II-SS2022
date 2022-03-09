package task_09_visitor;

import ExtinguishDevices.FrontCannon;
import ExtinguishDevices.GroundSprayNozzles;
import ExtinguishDevices.HeadCannon;
import ExtinguishDevices.WaterTank;
import task_01_Components.MixDeviceCommunicator;

public interface ITestApplication {
    boolean routine(GroundSprayNozzles type, WaterTank tank);
    boolean routine(FrontCannon type, MixDeviceCommunicator device);
    boolean routine(HeadCannon type, MixDeviceCommunicator device);
}
