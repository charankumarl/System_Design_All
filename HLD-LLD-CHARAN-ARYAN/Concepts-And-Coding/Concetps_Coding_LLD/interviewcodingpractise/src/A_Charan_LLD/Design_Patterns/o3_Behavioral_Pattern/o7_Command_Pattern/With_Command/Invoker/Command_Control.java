package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Invoker;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Command.Command;

public class Command_Control {

    Command command;

    public Command_Control(){
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
