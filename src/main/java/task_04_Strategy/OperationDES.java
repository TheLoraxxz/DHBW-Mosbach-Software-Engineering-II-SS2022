package task_04_Strategy;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class OperationDES implements IStrategy{
    Cipher ecipher;

    Cipher dcipher;

    public OperationDES(SecretKey key) throws Exception {
        ecipher = Cipher.getInstance("DES");
        dcipher = Cipher.getInstance("DES");
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }


    @Override
    public String doEncrypt(String Plain) throws Exception {
        // Encode the string into bytes using utf-8
        byte[] utf8 = Plain.getBytes("UTF8");

        // Encrypt
        byte[] enc = ecipher.doFinal(utf8);

        // Encode bytes to base64 to get a string
       return null;
    }

    @Override
    public String doDecrypt(String Plain) {
        return null;
    }
}
