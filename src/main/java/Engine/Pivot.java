package Engine;

public abstract class Pivot {
    private static long speed;
    public BreakDisk[] getBreakDisks() {
        return breakDisks;
    }

    private BreakDisk[] breakDisks;

    public Wheel[] getWheels() {
        return wheels;
    }

    private Wheel[] wheels;


    public Pivot() {
        Pivot.speed =0;
        breakDisks = new BreakDisk[6];
        for (int i = 0; i<6; i++)
        {
            breakDisks[i] = new BreakDisk();
        }
        wheels = new Wheel[]{new Wheel(),new Wheel()};
    }
    public long getSpeed() {
        return Pivot.speed;
    }
    public void setSpeed(long speed) {
        Pivot.speed = speed;
    }
}
