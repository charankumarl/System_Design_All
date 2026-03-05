package A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.ScheduleStratergy;

import A_Charan_LLD.Design_Patterns.LLDElevatorDesign.New_Design.Elevator.Elevator;

public class ScanSchedulingStrategy implements SchedulingStrategy{

    @Override
    public int getNextStop(Elevator elevator) {
        return 0;
    }
}