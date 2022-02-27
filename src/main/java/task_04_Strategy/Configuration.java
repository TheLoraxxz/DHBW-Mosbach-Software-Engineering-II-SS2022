package task_04_Strategy;

public enum Configuration {
    instance;
    public final String userDirectory = System.getProperty("user.dir");
    public final String fileSeparator = System.getProperty("file.separator");
    public final String lineSeparator = System.getProperty("line.separator");

    public final String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;

    public final String plainMessageFile = dataDirectory + fileSeparator + "message.txt";
    public final String keyDataFile = dataDirectory + fileSeparator + "key.txt";

    public final String logFileDirectory = userDirectory + fileSeparator + "log" + fileSeparator;
    public final String logFile = logFileDirectory + "des.log";
}
