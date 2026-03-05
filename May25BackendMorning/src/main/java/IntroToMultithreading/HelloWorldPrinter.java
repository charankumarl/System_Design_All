package IntroToMultithreading;

public class HelloWorldPrinter implements Runnable{
    public void print(){
        System.out.println("Hello world! from " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        // within this method you need to write your code

        print();
    }
}
