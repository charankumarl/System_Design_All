package A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.ScheduleStratergy;

import A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.Elevator.Elevator;

public interface SchedulingStrategy {

    // Determines the next stop for the given elevator
    int getNextStop(Elevator elevator);
}
