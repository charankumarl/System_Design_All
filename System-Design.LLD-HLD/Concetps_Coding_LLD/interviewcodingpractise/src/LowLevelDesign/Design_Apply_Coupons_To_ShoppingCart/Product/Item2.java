package LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.Product;

import LowLevelDesign.Design_Apply_Coupons_To_ShoppingCart.ProductType;

public class Item2 extends Product{

    public Item2(String name, Double price, ProductType type){
        super(name, price, type);
    }

    @Override
    public Double getPrice(){
        return price;
    }
}
