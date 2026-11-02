package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.Abstract_Factory;

public class Pizza_Factory_Producer{

    static Pizza_Factory factory;

    public static Pizza_Factory getFactory(String type) {

        if(type.equals("veg")){
            factory = new Veg_Pizza_Factory();
        }
        else if(type.equals("chicken")){
            factory = new Chicken_Pizza_Factory();
        }
        else{
            System.out.println("Invalid type");
            return null;
        }

        return factory;
    }
}
