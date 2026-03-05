package LowLevelDesign.LLDSnakeLadder;

import LowLevelDesign.LLDSnakeLadder.players.Player;

public class Cell {

    public Jump jump;
    public Player player;
    public int row;
    public int col;

    public Player getPlayer() {
        return player;
    }

    public Jump getJump() {
        return jump;
    }
}
