package DesignPrinciplesAndPatterns.Builder;

public class Client {
    public static void main(String[] args) {
        // Way 1 : Using long and multiple constructors
        // Way 2 : Using setters
        // Way 3 : Using a HashMap
        // Way 4 : Using another custom class to take input on behalf of original class

//        SoldItemBuilder soldItemBuilder = new SoldItemBuilder();
        SoldItem soldItem =
                SoldItem
                        .getBuilder()
                        .setId(1)
                        .setName("SoldItem")
                        .setPrice(100)
                        .setQuantity(10)
                        .setDiscount(0.2)
                        .setPrime(true)
                        .build();

//        soldItemBuilder.setId(1);
//        soldItemBuilder.setName("SomeItem");
//        soldItemBuilder.setPrice(100);
//        soldItemBuilder.setQuantity(10);
//        soldItemBuilder.setDiscount(.2);
//        soldItemBuilder.setPrime(true);

//        SoldItem soldItem = new SoldItem(soldItemBuilder);

    }
}


















