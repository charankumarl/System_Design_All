package A_Charan_LLD.Design_Patterns.Tic_Tac_Toe;

public class Board {

    int size;
    char[][] playingBoard;

    public Board(int size) {
        this.size = size;
        playingBoard = new char[size][size];

        createBoard();
    }

    void createBoard(){

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                playingBoard[i][j] = '-';
            }
        }
    }

    void displayBoard(){

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(playingBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isValidMove(int row, int col){

        if(row >= 0 && row < size && col >= 0 && col < size &&
                playingBoard[row][col] == '-'){

            return true;
        }

        return false;
    }

    void addMove(int row, int col, char piece){

        playingBoard[row][col] = piece;
    }

    boolean isBoardFull(){

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(playingBoard[i][j] == '-'){
                    return false;
                }
            }
        }

        return true;
    }
}
