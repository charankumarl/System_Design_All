package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o6_Interpreter.Using_Context;

public class Number_Expression implements Expression{

    private String var;

    public Number_Expression(String var){
        this.var = var;
    }

    @Override
    public int interpret(Interpret_Context context) {

        try{

            int num = Integer.parseInt(var);
            return num;
        }
        catch (NumberFormatException e){

            int num = context.getVal(var);
            return num;
        }
    }
}
