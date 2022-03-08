package task_04_Strategy;

public interface IStrategy {
    public String doEncrypt(String Plain) throws Exception;
    public String doDecrypt(String Plain) throws Exception;
}
