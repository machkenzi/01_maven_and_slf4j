import logger.MessageLogger;

public class Program {
    public static void main(String args[]) {
       var classThatLogs = new MessageLogger();
       classThatLogs.LogToStringToConsole("Test");
    }
}
