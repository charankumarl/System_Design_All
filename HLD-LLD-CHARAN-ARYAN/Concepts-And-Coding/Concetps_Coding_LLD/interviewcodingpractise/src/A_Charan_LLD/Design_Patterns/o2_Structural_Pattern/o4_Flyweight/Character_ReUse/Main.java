package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Character_ReUse;

public class Main {

    Character c1 = new Character('H', 0, StyleFactory.getStyle("Arial", 12, false)); // creates style
    Character c2 = new Character('i', 1, StyleFactory.getStyle("Arial", 12, false)); // reuses SAME style object
    Character c3 = new Character('!', 2, StyleFactory.getStyle("Arial", 12, true));  // new style (bold)

    /**
     * Output:
     *
     * Created NEW style: Arial 12
     * Created NEW style: Arial 12 bold
     *
     * Only 2 CharacterStyle objects created for 3 characters — c1 and c2 share the exact same style object.
     *
     * In a real 1-million-character document using mostly one font, you'd have maybe 5-10 style objects total instead of a million.
     *
     * Why this is Flyweight, not Object Pool: all 3 characters coexist and are displayed at the same time,
     * with c1 and c2 both actively holding a reference to the same shared style object simultaneously — nobody "returns" it when done.
     */
}
