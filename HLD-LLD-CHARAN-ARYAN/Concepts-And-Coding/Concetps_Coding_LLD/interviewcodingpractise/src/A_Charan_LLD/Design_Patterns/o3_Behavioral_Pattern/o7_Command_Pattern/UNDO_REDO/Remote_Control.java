package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.UNDO_REDO;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.With_Command.Command.Command;

import java.util.Stack;

public class Remote_Control {

    Command command;

    Stack<Command> stack = new Stack<>();
    Stack<Command> redoStack = new Stack<>();

    public void setCommand() {
    }

    public void setCommand(Command command) {
        this.command = command;
        stack.add(command);
    }

    public void pressButton() {
        if(command != null) {
            command.execute();
        }
        else{
            System.out.println("No command set");
        }
    }

    public void undo(){

        if(!stack.isEmpty()){

            redoStack.add(stack.pop());

            if(!stack.isEmpty()){
                Command lastCommand = stack.peek();
                lastCommand.execute();
            }
            else{
                System.out.println("Nothing to undo");
            }
        }
        else{
            System.out.println("Nothing to undo");
        }
    }

    public void redo(){

        if (!redoStack.isEmpty()) {

            Command lastUndoneCommand = redoStack.pop();
            stack.add(lastUndoneCommand);
            lastUndoneCommand.execute();
        }
        else {
            System.out.println("Nothing to redo");
        }
    }
}
