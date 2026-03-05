package LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product;

import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.ProductType;

public abstract class Product {

    String name;
    Double price;
    ProductType productType;

    public Product(){
    }

    public Product(String name, Double price, ProductType type) {
        this.name = name;
        this.price = price;
        this.productType = type;
    }

    public ProductType getProductType(){
        return productType;
    }

    public abstract Double getPrice();
}
