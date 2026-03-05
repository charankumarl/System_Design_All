package LowLevelDesign.LLDSnakeLadder.players;

import LowLevelDesign.LLDSnakeLadder.constants.PlayerType;
import LowLevelDesign.LLDSnakeLadder.constants.Symbol;
import LowLevelDesign.LLDSnakeLadder.stratergies.PlayingStratergies;

public class Bot extends Player {

    public Bot(String name, Symbol symbol, int currentPos, PlayerType playerType, PlayingStratergies playingStrtaergy) {
        super(name, symbol, currentPos, playerType, playingStrtaergy);
    }
}
