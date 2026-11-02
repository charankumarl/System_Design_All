package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o4_Chain_Responsibility;

public class Warning_Log extends LogProcess{

    Warning_Log(LogProcess next) {
        super(next);
    }

    public void logMessage(String message, int level) {

        if(level == WARNING){
            System.out.println("WARNING Log: " + message);
        }
        else{
            super.logMessage(message, level);
        }
    }
}
