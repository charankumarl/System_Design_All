package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Command.AC_TURN_OFF;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Command.AC_TURN_ON;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Invoker.Command_Control;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Reciever.AC;

public class Main {

    public static void main(String[] args) {

        AC ac = new AC();

        Command_Control turnOn = new Command_Control();   // 1. Create Command which we need.
        turnOn.setCommand(new AC_TURN_ON(ac));  // 2. Set the command to the invoker
        turnOn.pressButton();  // TURN ON                   // 2. Call the command

        Command_Control turnOff = new Command_Control();
        turnOff.setCommand(new AC_TURN_OFF(ac));  // 2. Set the command to the invoker
        turnOff.pressButton();  // TURN OFF

    }
}
