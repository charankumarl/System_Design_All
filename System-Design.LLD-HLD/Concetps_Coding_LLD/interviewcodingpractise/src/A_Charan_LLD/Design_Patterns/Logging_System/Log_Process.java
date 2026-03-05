package A_Charan_LLD.Design_Patterns.Logging_System;

public abstract class Log_Process {

    static final int INFO = 1;
    static final int WARN = 2;
    static final int ERROR = 3;

    Log_Process nextLogProcess;

    Log_Process(Log_Process nextLogProcess) {
        this.nextLogProcess = nextLogProcess;
    }

    public void log(int level, String message) {

        if (nextLogProcess != null) {
            nextLogProcess.log(level, message);
        }
    }
}
