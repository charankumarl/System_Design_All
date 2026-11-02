package LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart;

import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Decorator.Coupons_Decorator;
import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Decorator.Percentage_Coupon;
import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Decorator.Type_Coupon;
import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product.Product;

import java.util.*;

public class Shopping_Cart {

    List<Product> productList = new ArrayList<Product>();

    public void addToCart(Product product){

        Product productEligibleDiscount = new Type_Coupon(
                new Percentage_Coupon(product, 10.0), product.getProductType());

        productList.add(productEligibleDiscount);  // we are adding the product after all discount, latest price product.

        /*
             Execution Order:

            product.getProductType() is called.

            new Percentage_Coupon(product, 10.0) is created.

            new Type_Coupon(...) is created using the above two.
            -----------------------------------------------------------------------------------------------------

            Step-by-Step Execution Order:

            Inside-out execution: The expression new Percentage_Coupon(product, 10.0) is evaluated first, because it’s the
             inner-most constructor call.

            That result (an object of Percentage_Coupon, which probably implements or extends Product) is passed as the first
            argument to Type_Coupon.

            Then product.getProductType() is evaluated and passed as the second argument to Type_Coupon.

            Finally, a new Type_Coupon object is constructed using these two arguments.
            -------------------------------------------------------------------------------------------------------------

            If we have more coupons, then we can use Factory and create objects using Loops.

            1. Create a List<Coupons> and add All here.
            2. Then Iterate over Coupons List and create the object.
         */
    }

    public Double getPrice(){

        Double totalPrice = 0.0;

        for(Product product : productList){
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }
}
