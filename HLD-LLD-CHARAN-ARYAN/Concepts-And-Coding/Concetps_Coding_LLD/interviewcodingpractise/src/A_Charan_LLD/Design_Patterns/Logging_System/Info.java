package A_Charan_LLD.Design_Patterns.Logging_System;

public class Info extends Log_Process{

    Info(Log_Process nextLogProcess) {
        super(nextLogProcess);
    }

    public void log(int level, String message){

        if(level == INFO){
            System.out.println("Info: "+message);
        }
        else{

            super.log(level, message);
        }
    }
}
