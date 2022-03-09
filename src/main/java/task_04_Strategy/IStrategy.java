package task_04_Strategy;

public interface IStrategy {
    String doEncrypt(String Plain) throws Exception;
    String doDecrypt(String Plain) throws Exception;
}
