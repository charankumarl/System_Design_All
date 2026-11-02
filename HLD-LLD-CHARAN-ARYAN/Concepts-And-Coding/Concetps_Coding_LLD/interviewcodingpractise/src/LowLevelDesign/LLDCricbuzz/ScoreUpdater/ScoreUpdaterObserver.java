package LowLevelDesign.LLDCricbuzz.ScoreUpdater;


import LowLevelDesign.LLDCricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}
