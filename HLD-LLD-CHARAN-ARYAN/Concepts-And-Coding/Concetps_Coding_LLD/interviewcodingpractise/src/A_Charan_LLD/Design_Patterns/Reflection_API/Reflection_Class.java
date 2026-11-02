package A_Charan_LLD.Design_Patterns.Reflection_API;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Reflection_Class {

    public static void main(String[] args) throws Exception{

        Class<?> claszz = Sample.class;  // Sample is a class in the same package

//        Object obj = new Sample(); // You don't know the class at compile-time
//        Class<?> clazz = obj.getClass();

        String ClassName = claszz.getName();
        System.out.println("Class Name : " + ClassName);

        Method methods[] = claszz.getDeclaredMethods();

        for(Method method : methods){
            System.out.println("Method Name : " + method.getName());
        }

        //Sample sample = new Sample();  // cannot create since it is private

        Constructor<?> constructor = claszz.getDeclaredConstructor();

        constructor.setAccessible(true);

        Sample obj = (Sample) constructor.newInstance();
        System.out.println("Object created : " + obj);
    }
}
