package Cabine;

import main.java.FLF.CentralUnit;

public class ReceiverModule {
    private CentralUnit centralUnit;

    public ReceiverModule(CentralUnit pCentralUnit) {
        centralUnit = pCentralUnit;
    }

    public boolean TransferIDCode(String IDCode)
    {
        return centralUnit.CheckIDCode(IDCode);
    }
}
