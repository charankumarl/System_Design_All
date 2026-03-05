package DesignPrinciplesAndPatterns.Builder;

public class SoldItem {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private boolean isPrime;
    private double discount;
    private String paymentMethod;


    private SoldItem(SoldItemBuilder soldItemBuilder) {
        // validations can be done over here also
        this.id = soldItemBuilder.getId();
        this.name = soldItemBuilder.getName();
        this.price = soldItemBuilder.getPrice();
        this.quantity = soldItemBuilder.getQuantity();
        this.isPrime = soldItemBuilder.isPrime();
        this.discount = soldItemBuilder.getDiscount();
        this.paymentMethod = soldItemBuilder.getPaymentMethod();
    }

    // Original class is taking the responsbility of providing the builder
    public static SoldItemBuilder getBuilder(){
        return new SoldItemBuilder();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static class SoldItemBuilder {
        private int id;
        private String name;
        private int price;
        private int quantity;
        private boolean isPrime;
        private double discount;
        private String paymentMethod;

        public SoldItem build(){
            // let's say you are doing some validation
            return new SoldItem(this);
        }

        public SoldItemBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public SoldItemBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public SoldItemBuilder setPrime(boolean prime) {
            isPrime = prime;
            return this;
        }

        public SoldItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public SoldItemBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public SoldItemBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public SoldItemBuilder setQuantity(int quantity) {
            if(quantity < 5){
                throw new IllegalArgumentException("Quantity must be greater than 5");
            }
            this.quantity = quantity;
            return this;
        }

        public double getDiscount() {
            return discount;
        }

        public int getId() {
            return id;
        }

        public boolean isPrime() {
            return isPrime;
        }

        public String getName() {
            return name;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public int getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }


    }
}
