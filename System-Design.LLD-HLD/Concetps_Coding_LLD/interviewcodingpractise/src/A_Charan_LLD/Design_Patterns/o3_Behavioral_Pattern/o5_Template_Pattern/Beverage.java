package A_Charan_LLD.Design_Patterns.o3_Behavioral_Pattern.o5_Template_Pattern;

public abstract class Beverage {

    // Template Method - Defines the algorithm structure
    public final void prepareBeverage() {   // Final so, subclasses can't override this method
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {   // Common method for all subclasses
        System.out.println("Boiling water...");
    }

    protected abstract void brew(); // Subclass will implement this

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    protected abstract void addCondiments(); // Subclass will implement this
}
