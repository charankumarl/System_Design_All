package LowLevelDesign.DesignOrderManagementSystem.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {

    public int productCategoryId;
    public String categoryName;
    List<Product> products = new ArrayList<>();
    public Catergory categoryType;
    /*
    Here we are Categorizing the product with Catergory enum.  Electronics, Groceries, Fashion, etc.

    Each category can have multiple products.
     */


    public void addProduct(Product product, Catergory categoryType){
        products.add(product);
        this.categoryType = categoryType;
    }

    //remove products
    public void removeProduct(int count){
        for(int i=1;i<=count;i++){
            products.remove(0);
        }
    }

    //get products
}
