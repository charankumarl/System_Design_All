package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o6_Interpreter.Using_Context;

public class Main {

    public static void main(String[] args) {

        Interpret_Context context = new Interpret_Context();
        context.assign("x", 10);  // storing the value of x as 10 in map for context
        context.assign("y", 20);

        Expression x = new Number_Expression("x");
        Expression y = new Number_Expression("y");

        Expression add = new Add_Expression(x, y);
        System.out.println(add.interpret(context));
    }
}
