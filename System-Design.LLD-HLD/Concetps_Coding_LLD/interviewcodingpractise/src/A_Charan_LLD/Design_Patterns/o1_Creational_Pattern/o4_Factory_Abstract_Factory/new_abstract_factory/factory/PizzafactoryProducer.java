package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.factory;

public class PizzafactoryProducer {

    static Pizza_Factory pizzafactory;

    static Pizza_Factory getPizzafactory() {

        if(pizzafactory == null) {
            pizzafactory = new VegPizzaFactory();
        }
        return pizzafactory;
    }
}
