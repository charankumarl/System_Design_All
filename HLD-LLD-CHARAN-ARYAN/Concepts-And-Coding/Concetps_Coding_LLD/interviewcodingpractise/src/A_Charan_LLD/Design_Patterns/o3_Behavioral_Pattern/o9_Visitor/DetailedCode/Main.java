package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.DoubleRoomEle;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.IRoomElement;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element.SingleRoomEle;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Visitor.IRoomVisitor;
import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Visitor.PriceVisitor;

public class Main {

    public static void main(String[] args) {

        IRoomElement singleRoom = new SingleRoomEle();
        IRoomElement doubleRoom = new DoubleRoomEle();

        IRoomVisitor priceVisitor = new PriceVisitor();
        singleRoom.accept(priceVisitor);
        doubleRoom.accept(priceVisitor);
    }
}
