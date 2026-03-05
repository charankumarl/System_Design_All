package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o4_Chain_Responsibility;

public class Error_Log extends LogProcess{

    Error_Log(LogProcess next) {
        super(next);
    }

    public void logMessage(String message, int level) {

        if(level == ERROR){
            System.out.println("ERROR Log: " + message);
        }
        else{
            super.logMessage(message, level);
        }
    }
}
