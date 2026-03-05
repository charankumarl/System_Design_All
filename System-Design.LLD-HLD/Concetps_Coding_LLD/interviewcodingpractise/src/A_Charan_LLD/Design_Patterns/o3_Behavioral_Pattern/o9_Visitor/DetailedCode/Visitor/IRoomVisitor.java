package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Visitor;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.DoubleRoomEle;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.IRoomElement;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.SingleRoomEle;

public interface IRoomVisitor {

    public void visit(SingleRoomEle singleRoomEle);
    public void visit(DoubleRoomEle doubleRoomEle);
}
