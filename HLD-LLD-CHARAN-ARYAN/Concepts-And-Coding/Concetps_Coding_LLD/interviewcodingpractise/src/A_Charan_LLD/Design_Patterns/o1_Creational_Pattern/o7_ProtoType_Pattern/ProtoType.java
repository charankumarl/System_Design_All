package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern;

interface ProtoType extends Cloneable {

    ProtoType clone() throws CloneNotSupportedException;

    // clonable is a marker interface.
}
