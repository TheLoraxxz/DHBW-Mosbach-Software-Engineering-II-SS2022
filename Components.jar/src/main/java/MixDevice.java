import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class MixDevice {
    private int mixType;
    private Object water;
    private Object foam;
    private static MixDevice device;

    public MixDevice(Object water, Object foam) {
        this.mixType = 0;
        this.water = water;
        this.foam = foam;
    }
    public void defill(int amount)  {
        try {
        double foamV = amount*((this.mixType)/ 100);
        double waterV = amount-foamV;

        Method waterTakeout = this.water.getClass().getSuperclass().getDeclaredMethod("takeOut",float.class);
        waterTakeout.invoke(this.water,((float) waterV));
        Method foamTakeout = this.foam.getClass().getSuperclass().getDeclaredMethod("takeOut",float.class);
        foamTakeout.invoke(this.water,((float) foamV));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void setToNextMix() {
        switch(this.mixType){
            case 0 -> this.mixType = 3;
            case 3 -> this.mixType = 5;
            case 5 -> this.mixType = 10;
            case 10 -> this.mixType = 0;
        }
    }
    public static MixDevice getInstance(Object water,Object foam) {
        return Objects.requireNonNullElseGet(MixDevice.device, () -> new MixDevice(water, foam));
    }
    public Object getWaterTank() {
        return this.water;
    }
    public Object getFoamTank() {
        return this.foam;
    }
}
