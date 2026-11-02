package A_Charan_LLD.Design_Patterns.Parking_Lot.CostCompute;

public class Cost_Compute {

    Cost_Compute_Stratergy costComputeStratergy;

    Cost_Compute(Cost_Compute_Stratergy costComputeStratergy){

        this.costComputeStratergy = costComputeStratergy;
    }

    public int price(int time){

        return costComputeStratergy.price(time);
    }
}
