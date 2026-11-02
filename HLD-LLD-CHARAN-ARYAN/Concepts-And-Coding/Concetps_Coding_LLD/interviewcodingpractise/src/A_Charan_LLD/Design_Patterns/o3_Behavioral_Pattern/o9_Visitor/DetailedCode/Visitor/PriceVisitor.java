package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Visitor;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.DoubleRoomEle;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.IRoomElement;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.SingleRoomEle;

public class PriceVisitor implements IRoomVisitor{

    public void visit(SingleRoomEle singleRoomEle){
        singleRoomEle.price = 1000;
    }

    public void visit(DoubleRoomEle doubleRoomEle){
        doubleRoomEle.price = 2000;
    }
}
