package A_Charan_LLD.Design_Patterns.Tic_Tac_Toe;

public class Piece {

    private PieceType pieceType;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
