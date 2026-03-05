package A_Charan_LLD.Design_Patterns.Logging_System;

public class Main {

    public static void main(String[] args) {

        Log_Process logProcess = new Info(new Warn(new Error(null)));

        //logProcess.log(Log_Process.INFO, "This is an information");
        //logProcess.log(Log_Process.WARN, "This is a warning");
        logProcess.log(Log_Process.ERROR, "This is an error");

        /*
            1. We have created a chain like INFO -> WAR -> ERROR.

            2. Now log will go to INFO, it will check the LOG Level. If it cant then it will call super class log.

            3. There it will call the next.log method. It will go to WARN log, There it will check the Log Level.

            4. If it not satisfy, then it will call Super class, then it will go to ERROR log.

            -> If anything is process in between, then will not call the next.log method. It will process there only.
        */
    }
}
