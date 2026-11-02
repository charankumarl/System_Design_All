package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o4_Chain_Responsibility;

public class Main {

    public static void main(String[] args) {

        // Creating the chain of responsibility
        LogProcess log = new Info_Log(new Warning_Log(new Error_Log(null)));

        log.logMessage("this is message", LogProcess.INFO);
        log.logMessage("this is warning message", LogProcess.WARNING);
        log.logMessage("this is error message", LogProcess.ERROR);
    }
}
