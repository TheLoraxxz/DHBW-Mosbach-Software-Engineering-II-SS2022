package FLF;

import task_05_Adapter.Box;
import Cabine.Cabin;

public class FLF {

    private final CentralUnit centralUnit;
    private final Cabin cabin;
    private final Box box;

    public Cabin getCabin() {
        return cabin;
    }


    public Box getBatteries() {
        return box;
    }


    public CentralUnit getCentralUnit() {
        return centralUnit;
    }

    public FLF(Builder builder) {
        cabin = builder.cabin;
        centralUnit = builder.centralUnit;
        box = builder.batteries.boxx;
    }

    public static class Builder{
        private final Cabin cabin;
        private final CentralUnit centralUnit;
        private final Batterymanagement batteries;
        private static JoystickType types = JoystickType.seperate;
        public Builder() {
            batteries = Batterymanagement.instance;
            centralUnit = new CentralUnit(batteries.boxx,types);
            cabin = new Cabin(centralUnit.getDriverSection(),centralUnit.getOperatorSection(),batteries.boxx,this.centralUnit.getPivotsStatic(),centralUnit);
        }
        public static void setJoystickType(JoystickType type) {
            types = type;
        }
        public FLF build()
        {
            return new FLF(this);
        }
    }
}

