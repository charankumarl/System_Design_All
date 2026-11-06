package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Character_ReUse;

public class CharacterStyle {

    String fontFamily;
    int fontSize;
    boolean bold;

    CharacterStyle(String fontFamily, int fontSize, boolean bold) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.bold = bold;
        System.out.println("Created NEW style: " + fontFamily + " " + fontSize + (bold ? " bold" : ""));
    }
}
