package ExtinguishDevices;

import task_08_Observer.ISensorObserver;
import task_08_Observer.Sensor;

public abstract class Tank {
    protected boolean[][][] capacity;
    protected Sensor sensor;
    public Tank(ISensorObserver led) {
        this.sensor = new Sensor(led);
    }

    public void fill(int amount) {
        int max_cap = this.capacity.length*this.capacity[0].length*this.capacity[0][0].length;
        int cap = this.getCapacity();
        setColourLED(cap+amount,max_cap);
        if(amount+cap>=max_cap){
            for(int i=0;i<this.capacity.length;i++) {
                for(int j=0;j<this.capacity[0].length;j++) {
                    for(int k=0;k<this.capacity[0][0].length;k++) {
                        this.capacity[i][j][k]=true;
                    }
                }
            }   
        } else {
            int newAmm = amount+cap;
            for(int i =0;i<this.capacity.length;++i) {
                for (int j=0;j<this.capacity[0].length;++j) {
                    for (int k=0;k<this.capacity[0][0].length;++k) {
                        if(newAmm==0) {
                            return;
                        } else {
                            this.capacity[i][j][k]=true;
                            --newAmm;
                        }
                        
                    }
                }
            }
        }
    }

    public float takeOut(float foamV) {
        int amount = (int) foamV;
        int cap = this.getCapacity();
        setColourLED(cap+amount,this.capacity.length*this.capacity[0].length*this.capacity[0][0].length);
        for(int i=0;i<this.capacity.length;i++) {
            for(int j=0;j<this.capacity[0].length;j++) {
                for(int k=0;k<this.capacity[0][0].length;k++) {
                    this.capacity[i][j][k]=false;
                }
            }    
        }
        if (amount >= cap) {
            return 0;
        } else {
            int newAmm = cap-amount;
            for(int i =0;i<this.capacity.length;++i) {
                for (int j=this.capacity[0].length-1;j>=0;--j) {
                    for (int k=0;k<this.capacity[0][0].length;k++) {
                        if(newAmm==0) {
                            return foamV;
                        } else {
                            this.capacity[i][j][k]=true;
                            --newAmm;
                        }
                        
                    }
                }
            }
            return foamV;
        }   
    }

    public int getCapacity() {
        int cap =0;
        for (boolean[][] bs : capacity) {
            for (boolean[] bs2 : bs) {
                for (boolean bs3 : bs2) {
                    if(bs3) {
                        cap++;
                    }
                }
            }
        }
        return cap;
    }

    public void setColourLED(int cap,int maxcap) {
        if (cap*2<maxcap) {
            if (cap*10<maxcap) {
                this.sensor.lessThan10();
            } else if(cap*4<maxcap) {
                this.sensor.lessThan25();
            } else {
                this.sensor.lessThan50();
            }
        } else {
            this.sensor.moreThan50();
        }

    }
}
