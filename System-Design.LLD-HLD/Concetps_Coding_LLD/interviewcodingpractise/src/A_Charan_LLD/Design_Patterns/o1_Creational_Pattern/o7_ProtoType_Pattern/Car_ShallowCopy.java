package A_Charan_LLD.Design_Patterns.o1_Creational_Pattern.o7_ProtoType_Pattern;

import java.util.Arrays;

public class Car_ShallowCopy implements Cloneable {

    private String brand;
    private String model;
    private int price;
    private int[] arr;

    public Car_ShallowCopy(String brand, String model, int price, int arr[]) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.arr = arr;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public Car_ShallowCopy clone() throws CloneNotSupportedException {
        Car_ShallowCopy car = (Car_ShallowCopy) super.clone();
        return car;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
