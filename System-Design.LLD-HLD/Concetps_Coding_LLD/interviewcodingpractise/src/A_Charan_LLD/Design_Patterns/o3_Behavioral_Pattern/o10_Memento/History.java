package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o10_Memento;

import java.util.Stack;

public class History {  // Care Taker

    Stack<Memento> history = new Stack<>();

    public void save(Text_Editor editor){

        Memento memento = editor.save();
        history.push(memento);
    }

    public void undo(Text_Editor editor){

        if(!history.isEmpty()){

            Memento memento = history.pop();
            editor.restore(memento);
        }
        else{
            System.out.println("No more undo available");
        }
    }
}
