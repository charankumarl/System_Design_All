package LowLevelDesign.LLDSnakeLadder;

public class GameClient {

    public static void main(String args[]) {

        Game_Controller gameController = new Game_Controller();

        Game game = gameController.createGame();
        gameController.startGame(game);
    }
}
