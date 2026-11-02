package A_Charan_LLD.Design_Patterns.Parking_Lot.CostCompute;

public class Minutes implements Cost_Compute_Stratergy{

    @Override
    public int price(int time) {

        return (int) (time * 0.5);
    }
}
