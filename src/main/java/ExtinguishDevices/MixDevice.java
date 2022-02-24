package ExtinguishDevices;


public class MixDevice {
    private MixType mixType;
    private WaterTank water;
    private FoamTank foam;

    public MixDevice(WaterTank water,FoamTank foam) {
        this.mixType = MixType.zero;
        this.water = water;
        this.foam = foam;
    }
    public void defill(int amount) {
        float foamV = amount*(((float) this.mixType.getValue())/ 100);
        float waterV = amount-foamV; 
        this.water.takeOut(waterV);
        this.foam.takeOut(foamV);
    }
    public void setToNextMix() {
        switch(this.mixType){
            case zero -> this.mixType = MixType.three;
            case three -> this.mixType = MixType.five;
            case five -> this.mixType = MixType.ten;
            case ten -> this.mixType = MixType.zero;
        }
    }
    public WaterTank getWaterTank() {
        return this.water;
    }
    public FoamTank getFoamTank() {
        return this.foam;
    }
}
