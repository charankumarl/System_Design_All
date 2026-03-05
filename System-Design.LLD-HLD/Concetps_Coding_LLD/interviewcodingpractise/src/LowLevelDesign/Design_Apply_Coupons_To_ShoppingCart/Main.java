package LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart;

import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product.Item1;
import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product.Item2;
import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product.Product;

public class Main {

    public static void main(String[] args) {

        Shopping_Cart cart = new Shopping_Cart();

        cart.addToCart(new Item1("item1", 1000.0, ProductType.ELECTRONICS));
        cart.addToCart(new Item2("item2", 2000.0, ProductType.FURNITURE));

        Double price = cart.getPrice();
        System.out.println(price);
    }
}
