package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Visitor.IRoomVisitor;

public class DoubleRoomEle implements IRoomElement{

    public int price = 0;

    public void accept(IRoomVisitor visitor){

        visitor.visit(this);
    }
}
