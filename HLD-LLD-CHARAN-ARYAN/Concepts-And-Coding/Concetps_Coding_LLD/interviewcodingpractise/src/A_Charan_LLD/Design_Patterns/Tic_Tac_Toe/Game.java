package A_Charan_LLD.Design_Patterns.Tic_Tac_Toe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    Deque<Players> players = new LinkedList<>();
    Board board;

    Game(Deque<Players> players, int boardSize) {

        this.players = players;
        board = new Board(boardSize);
    }

    public void startGame(){

        boolean isGameWon = false;

        while (!isGameWon){

            board.displayBoard();

            Players currentPlayer = players.pollFirst();

            System.out.println("Player " + currentPlayer.getName() + " turn");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter row and column : ");

            int row = sc.nextInt();
            int col = sc.nextInt();

            if(!board.isValidMove(row, col)) {
                System.out.println("Invalid Move. Try again");
                players.addFirst(currentPlayer);
                continue;
            }

            board.addMove(row, col, currentPlayer.getPieceType().getName());

            players.addLast(currentPlayer);

            if(isWinner(currentPlayer.getPieceType().getName())){

                System.out.println("Player " + currentPlayer.getName() + " wins");
                isGameWon = true;
            }

            if(board.isBoardFull()){
                System.out.println("Game is a draw");
                isGameWon = true;
            }
        }
    }

    boolean isWinner(char pieceType){

        boolean isRowWinner = false;
        boolean isColWinner = false;
        boolean isDiagonalWinner = false;

        for(int i = 0; i < board.size; i++){

            for(int j = 0; j < board.size; j++){

                if(board.playingBoard[i][j] != pieceType) break;

                if(j == board.size - 1) isRowWinner = true;
            }
        }

        for(int i = 0; i < board.size; i++){

            for(int j = 0; j < board.size; j++){

                if(board.playingBoard[j][i] != pieceType) break;

                if(j == board.size - 1) isColWinner = true;
            }
        }

        for(int i = 0; i < board.size; i++){

            if(board.playingBoard[i][i] != pieceType) break;

            if(i == board.size - 1) isDiagonalWinner = true;
        }

        for(int i = 0; i < board.size; i++){

            if(board.playingBoard[i][board.size - i - 1] != pieceType) break;

            if(i == board.size - 1) isDiagonalWinner = true;
        }

        return isRowWinner || isColWinner || isDiagonalWinner;
    }
}
