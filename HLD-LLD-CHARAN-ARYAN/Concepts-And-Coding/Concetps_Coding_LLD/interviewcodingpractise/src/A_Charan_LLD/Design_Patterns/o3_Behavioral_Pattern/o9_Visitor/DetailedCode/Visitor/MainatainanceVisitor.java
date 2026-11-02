package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Visitor;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.DoubleRoomEle;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.SingleRoomEle;

public class MainatainanceVisitor implements IRoomVisitor{

    public void visit(SingleRoomEle singleRoomEle){
        System.out.println("Single Room Maintenance");
    }

    public void visit(DoubleRoomEle doubleRoomEle){
        System.out.println("Double Room Maintenance");
    }
}
