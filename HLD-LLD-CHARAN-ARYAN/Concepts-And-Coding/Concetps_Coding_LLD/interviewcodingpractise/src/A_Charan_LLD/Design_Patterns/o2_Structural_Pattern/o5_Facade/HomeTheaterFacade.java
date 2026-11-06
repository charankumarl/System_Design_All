package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o5_Facade;

public class HomeTheaterFacade {

    Lights lights;
    Projector projector;
    Speakers speakers;
    DvdPlayer dvdPlayer;

    HomeTheaterFacade(Lights lights, Projector projector, Speakers speakers, DvdPlayer dvdPlayer) {
        this.lights = lights;
        this.projector = projector;
        this.speakers = speakers;
        this.dvdPlayer = dvdPlayer;
    }

    // One simple call hides the multi-step coordination across 4 subsystems
    public void watchMovie() {
        lights.dim();
        projector.turnOn();
        speakers.setVolume(50);
        dvdPlayer.play();
    }

    public void endMovie() {
        dvdPlayer.stop();
        projector.turnOff();
        lights.on();
    }
}
