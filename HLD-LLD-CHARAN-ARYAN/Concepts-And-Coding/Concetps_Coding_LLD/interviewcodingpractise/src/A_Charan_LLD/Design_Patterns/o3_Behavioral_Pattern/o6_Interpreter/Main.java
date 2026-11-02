package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o6_Interpreter;

public class Main {

    public static void main(String[] args) {

        Expression num1 = new Number_Expression(3);  // Terminal Expression
        Expression num2 = new Number_Expression(2);
        Expression num3 = new Number_Expression(1);

        Expression add = new Add_Expression(num1, num2);  // Non Terminal. Provide the context
        System.out.println(add.interpret());

        Expression sub = new Subtract_Expression(add, num3);
        System.out.println(sub.interpret());
    }
}
