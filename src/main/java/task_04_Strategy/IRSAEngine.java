package task_04_Strategy;

public interface IRSAEngine {
    String encrypt(String plainMessage);

    String decrypt(String cipher);
}
