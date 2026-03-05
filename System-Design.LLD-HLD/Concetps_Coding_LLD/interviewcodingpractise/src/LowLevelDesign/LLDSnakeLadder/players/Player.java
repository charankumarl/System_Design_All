package LowLevelDesign.LLDSnakeLadder.players;

import LowLevelDesign.LLDSnakeLadder.Cell;
import LowLevelDesign.LLDSnakeLadder.Move;
import LowLevelDesign.LLDSnakeLadder.constants.PlayerType;
import LowLevelDesign.LLDSnakeLadder.constants.Symbol;
import LowLevelDesign.LLDSnakeLadder.stratergies.PlayingStratergies;

public abstract class Player {

    String name;
    Symbol symbol;
    public int currentPos;
    PlayingStratergies playingStratergies;
    PlayerType playerType;
    PlayingStratergies playingStrtaergy;

    public Player(String name, Symbol symbol, int currentPos, PlayerType playerType, PlayingStratergies playingStrtaergy) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.playingStrtaergy = playingStrtaergy;
        this.currentPos = currentPos;
    }

    public Move makeMove(){
        int val = playingStrtaergy.makeMove(this);
        return new Move(this, val);
    }

    protected Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayingStratergies getPlayingStrtaergy() {
        return playingStrtaergy;
    }

    public void setPlayingStrtaergy(PlayingStratergies playingStrtaergy) {
        this.playingStrtaergy = playingStrtaergy;
    }

    public PlayingStratergies getPlayingStratergies() {
        return playingStratergies;
    }

    public void setPlayingStratergies(PlayingStratergies playingStratergies) {
        this.playingStratergies = playingStratergies;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
