//package DesignPrinciplesAndPatterns.Builder;
//
//
//public class SoldItemBuilder {
//    private int id;
//    private String name;
//    private int price;
//    private int quantity;
//    private boolean isPrime;
//    private double discount;
//    private String paymentMethod;
//
//    public SoldItem build(){
//        return new SoldItem(this);
//    }
//
//    public SoldItemBuilder setDiscount(double discount) {
//        this.discount = discount;
//        return this;
//    }
//
//    public SoldItemBuilder setId(int id) {
//        this.id = id;
//        return this;
//    }
//
//    public SoldItemBuilder setPrime(boolean prime) {
//        isPrime = prime;
//        return this;
//    }
//
//    public SoldItemBuilder setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public SoldItemBuilder setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//        return this;
//    }
//
//    public SoldItemBuilder setPrice(int price) {
//        this.price = price;
//        return this;
//    }
//
//    public SoldItemBuilder setQuantity(int quantity) {
//        if(quantity < 5){
//            throw new IllegalArgumentException("Quantity must be greater than 5");
//        }
//        this.quantity = quantity;
//        return this;
//    }
//
//    public double getDiscount() {
//        return discount;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public boolean isPrime() {
//        return isPrime;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public int getQuantity() {
////        return quantity;
//    }
//
//
//}
//
//
//
