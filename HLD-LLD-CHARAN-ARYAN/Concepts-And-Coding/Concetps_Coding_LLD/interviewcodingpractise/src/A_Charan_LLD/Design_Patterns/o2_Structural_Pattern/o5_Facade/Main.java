package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o5_Facade;

public class Main {

    public static void main(String[] args) {

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                new Lights(), new Projector(), new Speakers(), new DvdPlayer());

        homeTheater.watchMovie();
        System.out.println("--- movie playing ---");
        homeTheater.endMovie();
    }

    /**
        WITHOUT Facade:
        Client has to know about every subsystem and call each one in the correct order itself.

            Lights lights = new Lights();
            Projector projector = new Projector();
            Speakers speakers = new Speakers();
            DvdPlayer dvdPlayer = new DvdPlayer();

            lights.dim();
            projector.turnOn();
            speakers.setVolume(50);
            dvdPlayer.play();

            // ... watch movie ...

            dvdPlayer.stop();
            projector.turnOff();
            lights.on();

        4 objects, 7 calls, client must remember the right order every single time.

        WITH Facade:
        Client only talks to HomeTheaterFacade. It doesn't know Lights/Projector/Speakers/DvdPlayer
        exist, or in what order they need to be called.

            HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                    new Lights(), new Projector(), new Speakers(), new DvdPlayer());

            homeTheater.watchMovie();
            homeTheater.endMovie();

        2 calls. Facade hides the coordination of all 4 subsystems inside watchMovie()/endMovie().
     */
}
