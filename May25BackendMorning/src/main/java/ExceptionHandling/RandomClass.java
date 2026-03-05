package ExceptionHandling;

import java.io.FileNotFoundException;

public class RandomClass {
    static void randomMethod()  {
        System.out.println(1/0);
    }

    static void SomeMethod(int x) throws FileNotFoundException{
        if(x % 2 == 0){
            // Run-time exception : unchecked
            throw new IllegalArgumentException();
        } else {
            // Exception
            throw new FileNotFoundException();
        }
    }
}
