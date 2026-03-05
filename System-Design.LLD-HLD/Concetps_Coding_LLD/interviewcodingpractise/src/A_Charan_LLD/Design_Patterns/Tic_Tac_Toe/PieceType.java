package A_Charan_LLD.Design_Patterns.Tic_Tac_Toe;

public enum PieceType {

    O('O'),
    X('X');

    private char name;

    PieceType(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }
}
