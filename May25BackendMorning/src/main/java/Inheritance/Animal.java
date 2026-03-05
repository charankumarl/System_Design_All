package Inheritance;

public class Animal {
    private String name;

    public Animal(){
    }

    public Animal(String name){
        name = name;
    }

    void walk(){
        System.out.println(this.name + " is walking");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
