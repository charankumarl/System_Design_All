package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o6_Interpreter;

public class Number_Expression implements Expression{

    int number;

    Number_Expression(int number){
        this.number = number;
    }

    public int interpret(){
        return number;
    }
}
