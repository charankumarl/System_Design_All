package A_Charan_LLD.Design_Patterns.Logging_System;

public class Error extends Log_Process{

    Error(Log_Process nextLogProcess) {
        super(nextLogProcess);
    }

    public void log(int level, String message){

        if(level == ERROR){
            System.out.println("ERROR: "+message);
        }
        else{
            super.log(level, message);
        }
    }
}
