package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Element;

import A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o9_Visitor.DetailedCode.Visitor.IRoomVisitor;

public interface IRoomElement  {

    public void accept(IRoomVisitor visitor);
}
