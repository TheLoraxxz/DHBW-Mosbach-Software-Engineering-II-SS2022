package Person;

import task_04_Strategy.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class RFIDChip {
    private IStrategy strategy = null;
    private String ID;

    public String getID() {
        return ID;
    }
    public RFIDChip(String id) {
        ID = id;
    }

    public void encrypt(Algorithms algorithm) throws Exception {
        if (algorithm == Algorithms.DES)
        {
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            strategy = new OperationDES(key);
        }
        if (algorithm == Algorithms.AES)
        {
            strategy = new OperationAES();
        }
        if (algorithm == Algorithms.RSA)
        {
            strategy = new OperationAES();
        }
        ID = strategy.doEncrypt(ID);
    }

    public void decrypt() throws Exception {
        ID = strategy.doDecrypt(ID);
    }
}
