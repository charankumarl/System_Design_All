package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o6_Interpreter.Using_Context;

import java.util.HashMap;

public class Interpret_Context {

    HashMap<String, Integer> map = new HashMap<>();

    public void assign(String var, int value){
        map.put(var, value);
    }

    public int getVal(String var){
        return map.getOrDefault(var, 0);
    }
}
