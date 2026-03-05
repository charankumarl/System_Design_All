package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o6_Interpreter;

public class Add_Expression implements Expression{

    private Expression leftExpression;
    private Expression rightExpression;

    public Add_Expression(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}
