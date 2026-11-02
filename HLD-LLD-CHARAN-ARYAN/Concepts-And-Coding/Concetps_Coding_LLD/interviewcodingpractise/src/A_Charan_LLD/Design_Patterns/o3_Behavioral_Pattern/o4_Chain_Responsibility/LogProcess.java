package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o4_Chain_Responsibility;

public abstract class LogProcess {

    public static int INFO = 1;
    public static int WARNING = 2;
    public static int ERROR = 3;

    LogProcess nextLogProcess;

    LogProcess(LogProcess nextLogProcess){
        this.nextLogProcess = nextLogProcess;
    }

    public void logMessage(String message, int level){

        if(nextLogProcess != null){
            nextLogProcess.logMessage(message, level);
        }
    }
}
