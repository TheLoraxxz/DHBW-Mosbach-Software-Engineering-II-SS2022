package task_04_Strategy;

public class OperationRSA implements IStrategy{

    RSAEngine engine;

    @Override
    public String doEncrypt(String Plain) {
        int keySize = 512;
        engine = new RSAEngine(keySize);
        return engine.encrypt(Plain);
    }

    @Override
    public String doDecrypt(String cipher) {
        return engine.decrypt(cipher);
    }
}
