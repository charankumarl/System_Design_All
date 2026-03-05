package LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Decorator;

import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product.Product;
import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.ProductType;

import java.util.ArrayList;
import java.util.List;

public class Type_Coupon extends Coupons_Decorator{

    Product product;
    ProductType type;

    static List<ProductType> apllicableTypeList = new ArrayList<>();

    static {
        apllicableTypeList = List.of(ProductType.ELECTRONICS, ProductType.CLOTHES);
    }

    public Type_Coupon(Product product, ProductType type){
        this.product = product;
        this.type = type;
    }

    public Double getPrice(){

        boolean isApllicable = false;

        for(ProductType type : apllicableTypeList){
            if(type == this.type){
                isApllicable = true;
                break;
            }
        }

        if(isApllicable){

            // give 100 discount;
            return product.getPrice() - 100;
        }
        return product.getPrice();
    }
}
