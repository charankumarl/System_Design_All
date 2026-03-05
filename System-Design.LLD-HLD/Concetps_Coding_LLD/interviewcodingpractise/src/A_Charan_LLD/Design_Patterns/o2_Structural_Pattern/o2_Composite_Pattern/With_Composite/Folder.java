package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o2_Composite_Pattern.With_Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements File_System{

    private String name;

    private List<File_System> FILE_FOLDER = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void add(File_System component) {
        FILE_FOLDER.add(component);
    }

    @Override
    public void show() {

        System.out.println("Folder: " + name);

        for (File_System component : FILE_FOLDER) {
            component.show();
        }
    }
}
