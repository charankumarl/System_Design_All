package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o10_Memento;

public class Main {

    public static void main(String[] args) {

        Text_Editor editor = new Text_Editor();
        History history = new History();

        editor.write("My name");
        history.save(editor);

        editor.write("charan");
        System.out.println(editor.getText());

        history.undo(editor);
        System.out.println(editor.getText());

        history.undo(editor);
    }
}
