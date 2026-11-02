package LowLevelDesign.LLDSnakeLadder.stratergies;

import LowLevelDesign.LLDSnakeLadder.Board;
import LowLevelDesign.LLDSnakeLadder.Cell;
import LowLevelDesign.LLDSnakeLadder.players.Player;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class OneDice_Playing_Stratergies implements PlayingStratergies {

    Scanner sc = new Scanner(System.in);

    @Override
    public int makeMove( Player player) {

        int dice = 1;
        System.out.println("press enter to play again");
        int nextInd = ThreadLocalRandom.current().nextInt(1, 6);
        System.out.println("next ind is " + nextInd);

        int currPos = player.getCurrentPos();

        currPos = currPos + nextInd;

        if(currPos > 99){
            currPos = 99;
        }

        return currPos;
    }
}
