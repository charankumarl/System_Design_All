package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Command;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Reciever.AC;

public class AC_TURN_OFF implements Command {

    private AC ac;

    public AC_TURN_OFF(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {

        ac.pressStop();
        ac.turnOff();
    }
}
