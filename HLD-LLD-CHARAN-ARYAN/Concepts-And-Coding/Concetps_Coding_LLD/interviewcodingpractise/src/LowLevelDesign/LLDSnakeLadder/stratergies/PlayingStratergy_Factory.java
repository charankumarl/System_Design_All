package LowLevelDesign.LLDSnakeLadder.stratergies;

import LowLevelDesign.LLDSnakeLadder.constants.PlayerType;

public class PlayingStratergy_Factory {

    public static PlayingStratergies create(PlayerType playerType) {
        switch (playerType) {
            case HUMAN:
                return new OneDice_Playing_Stratergies();

            case BOT:
                return new TwoDice_Playing_Stratergis();

            default:
                System.out.println("invalid player type");
                return null;
        }
    }
}
