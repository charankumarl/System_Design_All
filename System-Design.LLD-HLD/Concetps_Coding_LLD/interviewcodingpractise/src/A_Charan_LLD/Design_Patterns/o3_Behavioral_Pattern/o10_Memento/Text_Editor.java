package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o10_Memento;

public class Text_Editor {  // Originator

    private String text = "";

    public void write(String content){

        text += " " + content;
    }

    public String getText(){
        return text;
    }

    public Memento save(){

        return new Memento(text);  // return the new memento object with current state
    }

    public void restore(Memento memento){
        text = memento.getText();  // updating the text with previous state
    }
}
