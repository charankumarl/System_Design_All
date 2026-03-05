package A_Charan_LLD.Design_Patterns.Parking_Lot.CostCompute;

public class Hours implements Cost_Compute_Stratergy{

    @Override
    public int price(int time) {

        if(time < 60){
            return 10;
        }

        return (time / 60) * 10;
    }
}
