package LowLevelDesign.LLDSnakeLadder;

import LowLevelDesign.LLDSnakeLadder.players.Player;

public class Move {

    public Player player;
    public int pos;

    public Move(Player player, int pos) {
        this.player = player;
        this.pos = pos;
    }
}
