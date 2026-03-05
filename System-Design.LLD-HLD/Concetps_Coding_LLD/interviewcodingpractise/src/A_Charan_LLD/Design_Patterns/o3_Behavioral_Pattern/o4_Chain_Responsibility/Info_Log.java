package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o4_Chain_Responsibility;

public class Info_Log extends LogProcess{

    Info_Log(LogProcess next) {
        super(next);
    }

    public void logMessage(String message, int level) {

        if(level == INFO){
            System.out.println("Info Log: " + message);
        }
        else{
            super.logMessage(message, level);
        }
    }
}
