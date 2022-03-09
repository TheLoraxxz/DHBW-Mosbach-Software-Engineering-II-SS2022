package Cabine;

import FLF.CentralUnit;

public class ReceiverModule {
    private final CentralUnit centralUnit;

    public ReceiverModule(CentralUnit pCentralUnit) {
        centralUnit = pCentralUnit;
    }

    public boolean TransferIDCode(String IDCode)
    {
        return centralUnit.CheckIDCode(IDCode);
    }
}
