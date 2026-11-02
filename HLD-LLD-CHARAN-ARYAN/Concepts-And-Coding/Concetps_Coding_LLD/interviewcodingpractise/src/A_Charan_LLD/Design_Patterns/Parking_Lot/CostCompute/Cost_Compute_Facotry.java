package A_Charan_LLD.Design_Patterns.Parking_Lot.CostCompute;

public class Cost_Compute_Facotry {

    public static Cost_Compute getCostCompute(String type){

        Cost_Compute costCompute;

        if(type.equals("two wheelers Hours")) {
            costCompute = new Two_Wheelers(new Hours());
        }
        else if (type.equals("two wheelers Minutes")) {
            costCompute = new Two_Wheelers(new Minutes());
        }
        else if (type.equals("Four wheelers Minutes")) {
            costCompute = new Four_Wheelers(new Minutes());
        }
        else if (type.equals("Four wheelers Hours")) {
            costCompute = new Four_Wheelers(new Hours());
        }
        else{
            costCompute = null;
        }

        return costCompute;
    }
}
