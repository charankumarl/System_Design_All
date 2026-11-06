package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Character_ReUse;

public class Character {

    char symbol;              // extrinsic
    int position;             // extrinsic
    CharacterStyle style;     // intrinsic — shared reference, not duplicated

    Character(char symbol, int position, CharacterStyle style) {
        this.symbol = symbol;
        this.position = position;
        this.style = style;
    }
}
