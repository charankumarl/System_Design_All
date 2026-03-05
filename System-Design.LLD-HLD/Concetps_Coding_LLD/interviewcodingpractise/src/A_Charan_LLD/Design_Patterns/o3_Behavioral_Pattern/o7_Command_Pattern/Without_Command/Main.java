package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o7_Command_Pattern.Without_Command;

public class Main {

    public static void main(String[] args) {

        AC ac = new AC();

        // Turn on AC
        ac.plugIn();
        ac.pressStart();
        ac.trunOn();

        /*
            If new feature is added to AC, then we need to add new methods in AC class. And alos want to add new methods in Main class.

            So we want to change the client code and also client need to know the new methods added in AC class.

            -> But client should not know all this method, just he need to pass command as
            TURN ON rest of the things should be taken care by AC class.

            -> This is why we need to USE command pattern.
         */
    }
}
