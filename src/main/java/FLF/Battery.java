package FLF;

public class Battery {
    private boolean[][][] capacity;
    public Battery() {
        this.capacity = new boolean[100][10][100];
        for(int i=0;i<this.capacity.length;i++) {
            for(int j=0;j<this.capacity[0].length;j++) {
                for(int k=0;k<this.capacity[0][0].length;k++) {
                    this.capacity[i][j][k]=true;
                }
            }    
        }
    }

    public void takeOut(double capacity) {
        int amount = (int) capacity;
        for(int i=0;i<this.capacity.length;i++) {
            for(int j=0;j<this.capacity[0].length;j++) {
                for(int k=0;k<this.capacity[0][0].length;k++) {
                    this.capacity[i][j][k]=false;
                }
            }    
        }
        for(int i =0;i<this.capacity.length;++i) {
            for (int j=0;j<this.capacity[0].length;++j) {
                for (int k=0;k<this.capacity[0][0].length;++k) {
                    if(amount==0) {
                        return;
                    } else {
                        this.capacity[i][j][k]=true;
                        --amount;
                    }
                    
                }
            }
        }  
    }

    public void charge(int amount) {
        int max_cap = this.capacity.length*this.capacity[0].length*this.capacity[0][0].length;
        int cap = (int) this.getCapacity();
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
}
