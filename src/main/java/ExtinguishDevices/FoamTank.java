package ExtinguishDevices;

import task_08_Observer.ISensorObserver;

public class FoamTank extends Tank{
    public FoamTank(ISensorObserver led) {
        super(led);
        this.capacity = new boolean[75][45][10];
        for(int i=0;i<this.capacity.length;i++) {
            for(int j=0;j<this.capacity[0].length;j++) {
                for(int k=0;k<this.capacity[0][0].length;k++) {
                    this.capacity[i][j][k]=true;
                }
            }    
        }
    }
}
