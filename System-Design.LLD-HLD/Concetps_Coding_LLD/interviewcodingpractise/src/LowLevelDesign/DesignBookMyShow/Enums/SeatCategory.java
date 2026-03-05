package LowLevelDesign.DesignBookMyShow.Enums;

public enum SeatCategory {

    SILVER("Silver"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM");

    /*
    We can also mention 2 parameters or multiple inside the enum PLATINUM("PLATINUM", 100)
     */

    private String name;  // then we need to have field for those also. int price;

    SeatCategory(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SeatCategory getFromNames(String name){

        for(SeatCategory seatCategory : SeatCategory.values()){

            if(seatCategory.getName().equals(name)){
                return seatCategory;
            }
        }

        return null;
    }
}
