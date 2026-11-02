package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o2_Composite_Pattern.Without_Composite;

public class Main {

    public static void main(String[] args) {

        File file1 = new File("File1");
        File file2 = new File("File2");

        Folder root = new Folder("Root");

        Folder folder1 = new Folder("Folder1");
        Folder folder2 = new Folder("Folder2");

        root.addFile(file1);
        root.addFile(file2);

        root.addFolder(folder1);
        root.addFolder(folder2);

        root.show();
    }
}
