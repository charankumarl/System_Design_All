package A_Charan_LLD.Design_Patterns.o2_Structural_Pattern.o4_Flyweight.Robot_Game.With_FlyWeight;

import java.util.HashMap;

public class Robot_Factory {

    static HashMap<String, IRobot> cache = new HashMap<>();

    public static IRobot createRobot(String type){

        IRobot robot = null;

        if(cache.containsKey(type)){  // if present, use it from cache. dont create new one
            return cache.get(type);
        }
        else{
            if(type.equals("human")){    // else create new one, and store it in cache for future purpose.
                robot = new Human_Robot(type);
                cache.put(type, robot);
            }
            else if(type.equals("android")){
                robot = new Andriod_Robot(type);
                cache.put(type, robot);
            }
        }

        return robot;
    }
}
