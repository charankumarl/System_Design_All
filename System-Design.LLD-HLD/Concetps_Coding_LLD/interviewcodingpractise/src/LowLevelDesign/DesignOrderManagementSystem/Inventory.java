package LowLevelDesign.DesignOrderManagementSystem;

import LowLevelDesign.DesignOrderManagementSystem.Product.Catergory;
import LowLevelDesign.DesignOrderManagementSystem.Product.Product;
import LowLevelDesign.DesignOrderManagementSystem.Product.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {

    //category wise products storage
    List<ProductCategory> productCategoryList;

    Inventory(){
        productCategoryList = new ArrayList<>();
    }

    //add new category
    public void addCategory(int categoryId, String name, Catergory catergory){
        ProductCategory productCategory = new ProductCategory();
        productCategory.categoryName = name;
        productCategory.productCategoryId = categoryId;
        productCategory.categoryType = catergory;
        productCategoryList.add(productCategory);
    }


    //add product to the particular category
    public void addProduct(Product product, int productCategoryId){

        //take out the respective productCategory Object
        ProductCategory categoryObject = null;
        for(ProductCategory category : productCategoryList)
        {
            if(category.productCategoryId == productCategoryId){
                categoryObject = category;
            }
        }

        if(categoryObject !=null) {
            categoryObject.addProduct(product, categoryObject.categoryType);
        }
    }

    //remove product from the category
    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){

        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
             category.removeProduct(entry.getValue());
        }

    }

    private ProductCategory getProductCategoryFromID(int productCategoryId){

        for(ProductCategory productCategory : productCategoryList){

            if(productCategory.productCategoryId == productCategoryId){
                return productCategory;
            }
        }

        return null;
    }
}
