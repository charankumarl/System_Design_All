package LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Decorator;

import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product.Product;

public class Percentage_Coupon extends Coupons_Decorator{

    Product product;
    Double discountPercentage;

    public Percentage_Coupon(Product product, Double discountPercentage){
        this.product = product;
        this.discountPercentage = discountPercentage;
    }

    public Double getPrice(){

        Double price = product.getPrice();

        Double discountPrice = price - ( price * discountPercentage) / 100.0;

        return discountPrice;
    }
}
