package task_04_Strategy;

public interface IDESEngine {
    String encrypt(String string, String key);

    String decrypt(String string, String key);
}
