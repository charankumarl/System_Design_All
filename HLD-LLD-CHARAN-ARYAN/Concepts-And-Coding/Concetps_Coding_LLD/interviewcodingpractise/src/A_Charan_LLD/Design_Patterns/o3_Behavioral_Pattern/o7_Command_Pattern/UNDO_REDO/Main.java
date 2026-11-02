package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.UNDO_REDO;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Command.AC_TURN_OFF;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Command.AC_TURN_ON;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Reciever.AC;

public class Main {

    public static void main(String[] args) {

        AC ac = new AC();
        Remote_Control remoteControl = new Remote_Control();

        remoteControl.setCommand(new AC_TURN_ON(ac));  // 1. Turn On
        remoteControl.pressButton();

        remoteControl.setCommand(new AC_TURN_OFF(ac));  // Turn OFF
        remoteControl.pressButton();

        remoteControl.undo();  // 1. undo - OFF -> ON
        remoteControl.redo();  // 2. Redo - ON -> OFF
    }
}
