package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o2_Composite_Pattern.Without_Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder {

    String name;

    List<File> files = new ArrayList<>();
    List<Folder> folders = new ArrayList<>();

    List<Object> fileFolders = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
        fileFolders.add(file);
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
        fileFolders.add(folder);
    }

    public void show() {

        System.out.println("Folder: " + name);

        for (File file : files) {
            file.show();
        }

        for (Folder folder : folders) {
            folder.show();
        }

        for(Object item : fileFolders){  // we need to use Object and if else evrywhere. So it difficult if we have some many diff
                                         // items in Folder.
            if(item instanceof File){

                ((File)item).show();
            }
            else if(item instanceof Folder){

                ((Folder)item).show();
            }
        }
    }
}
