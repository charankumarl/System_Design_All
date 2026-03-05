package A_Charan_LLD.Design_Patterns.Logging_System;


public class Warn extends Log_Process {

    Warn(Log_Process nextLogProcess) {
        super(nextLogProcess);
    }

    public void log(int level, String message){

        if(level == WARN){
            System.out.println("WARN: "+message);
        }
        else{
            super.log(level, message);
        }
    }

}
