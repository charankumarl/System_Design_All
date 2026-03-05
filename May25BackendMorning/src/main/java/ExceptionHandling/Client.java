package ExceptionHandling;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        RandomClass.randomMethod();
        RandomClass.SomeMethod(10);
    }
}
