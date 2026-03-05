package A_Charan_LLD.Design_Patterns.Tic_Tac_Toe;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Players player1 = new Players("Charan", PieceType.X);
        Players player2 = new Players("Tharunya", PieceType.O);

        Deque<Players> playersList = new LinkedList<>();

        playersList.add(player1);
        playersList.add(player2);

        Game game = new Game(playersList, 3);

        game.startGame();
    }
}
