package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.factory;


import A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o4_Factory_Abstract_Factory.new_abstract_factory.pizza.Pizza;

public interface Pizza_Factory {

    Pizza createPizza(String type);
}
