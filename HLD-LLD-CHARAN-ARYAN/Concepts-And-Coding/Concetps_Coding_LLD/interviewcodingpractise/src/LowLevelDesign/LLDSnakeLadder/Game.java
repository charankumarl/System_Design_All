package LowLevelDesign.LLDSnakeLadder;

import LowLevelDesign.LLDSnakeLadder.constants.GameState;
import LowLevelDesign.LLDSnakeLadder.constants.PlayerType;
import LowLevelDesign.LLDSnakeLadder.constants.Symbol;
import LowLevelDesign.LLDSnakeLadder.players.Human;
import LowLevelDesign.LLDSnakeLadder.players.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    Board board;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;
    GameState gameState;

    public Game(){

        initializeGame();
    }

    private void initializeGame() {

        board = new Board(10, 5,4);
        winner = null;
        addPlayers();
        gameState = GameState.INPROGRESS;
    }

    private void addPlayers() {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter player name: ");
//        String name = sc.nextLine();
//        System.out.println("Enter Symbol: ");
//        Symbol symbol = Symbol.valueOf(sc.nextLine());
//        System.out.println("Enter player number: ");
//        int playerNumber = sc.nextInt();
//
//        Player player1 = new Human(name, symbol, playerNumber, PlayerType.HUMAN);

        Player player1 = new Human("p1", Symbol.GREEN, 0, PlayerType.HUMAN);
        Player player2 = new Human("p2", Symbol.RED, 0, PlayerType.HUMAN);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame(){

        while(winner == null && gameState == GameState.INPROGRESS) {

            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.getName() + " current position is: " + playerTurn.getCurrentPos());

            //get the new position
            Move move =  playerTurn.makeMove();
            int playerNewPosition = move.pos;

            playerNewPosition = jumpCheck(playerNewPosition);   // check for snake amd ladder.

            playerTurn.currentPos = playerNewPosition;   // save the new position.

            System.out.println("player turn is:" + playerTurn.getName() + " new Position is: " + playerNewPosition);

            if(playerNewPosition >= board.cells.length * board.cells.length-1){  //check for winning condition

                winner = playerTurn;
                gameState = GameState.SUCCEEDED;
            }
        }
        System.out.println("Game is over" + gameState);
        System.out.println("WINNER IS:" + winner.getName());
    }


    private Player findPlayerTurn() {

        Player playerTurns = playersList.removeFirst();  // use queue also, so that we can get player in order.
        playersList.addLast(playerTurns);
        return playerTurns;
    }

    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition >= board.cells.length * board.cells.length-1 ){  // 1. if cross 99, then return same position. win
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);   // get cell of new position. cell obj.

        if(cell.jump != null && cell.jump.start == playerNewPosition) {  // 2. if cell has jump, then jump to end of jump.

            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";

            System.out.println("jump done by: " + jumpBy);

            return cell.jump.end;   // return end of jump.
        }
        return playerNewPosition;   // if there is no snake or ladder, return same position.
    }
}
