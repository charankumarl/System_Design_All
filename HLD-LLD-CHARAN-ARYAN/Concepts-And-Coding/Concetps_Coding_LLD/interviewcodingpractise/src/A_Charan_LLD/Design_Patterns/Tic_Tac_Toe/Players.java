package A_Charan_LLD.Design_Patterns.Tic_Tac_Toe;

public class Players {

    String name;
    PieceType pieceType;

    public Players(String name, PieceType pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
