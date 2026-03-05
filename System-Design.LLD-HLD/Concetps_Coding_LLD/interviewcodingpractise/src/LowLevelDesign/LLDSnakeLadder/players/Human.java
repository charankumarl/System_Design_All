package LowLevelDesign.LLDSnakeLadder.players;

import LowLevelDesign.LLDSnakeLadder.Move;
import LowLevelDesign.LLDSnakeLadder.constants.PlayerType;
import LowLevelDesign.LLDSnakeLadder.constants.Symbol;
import LowLevelDesign.LLDSnakeLadder.stratergies.PlayingStratergy_Factory;

public class Human extends Player {

    public Human(String name, Symbol symbol, int currentPos, PlayerType playerType) {
        super(
                name,
                symbol,
                currentPos,
                playerType,
                PlayingStratergy_Factory.create(playerType)
        );
    }

    public Move makeMove(){
        int val = playingStrtaergy.makeMove(this);
        return new Move(this, val);
    }

}
