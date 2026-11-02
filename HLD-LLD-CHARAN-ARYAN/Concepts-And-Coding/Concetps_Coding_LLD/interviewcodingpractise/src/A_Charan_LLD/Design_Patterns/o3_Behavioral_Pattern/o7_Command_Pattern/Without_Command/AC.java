package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.Without_Command;

public class AC implements Electronics{

    boolean plugIn = false;
    boolean start = false;
    boolean pressStop = false;

    @Override
    public void trunOn() {
        if(plugIn && start){
            System.out.println("AC is on");
        }else{
            System.out.println("Plugin first and press start button to turn ON");
        }
    }

    @Override
    public void turnOff() {
        if(pressStop) {
            System.out.println("AC is off");
        }
        else{
            System.out.println("Press Stop button first to turn OFF");
        }
    }

    public void plugIn(){
        plugIn = true;
        System.out.println("AC is plugged in");
    }

    public void pressStart(){
        start = true;
        System.out.println("AC is started");
    }

    public void pressStop(){
        pressStop = true;
        System.out.println("AAC is plugged out");
    }
}
