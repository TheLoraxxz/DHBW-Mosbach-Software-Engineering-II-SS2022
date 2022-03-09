package ExtinguishDevices;

import task_01_Components.MixType;

public interface ICannon {
    void pumpOut(MixType mixType);
    void setCannonState(CannonState cannonState);
}
