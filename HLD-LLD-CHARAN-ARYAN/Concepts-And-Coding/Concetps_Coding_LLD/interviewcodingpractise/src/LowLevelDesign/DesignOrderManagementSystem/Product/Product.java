package LowLevelDesign.DesignOrderManagementSystem.Product;

public class Product {

    public int productId;
    public String productName;
    public String productDescription = "some description";
    public double price;
    /*
        Price can be vary dynamically, so we will use a strategy pattern to calculate the price.
     */
    public ProductPriceStratergy productPriceStratergy;
    public int quantityAvailable = 100;
    /*
        Quantity is availbale at product level only, not at category level.
     */

    public Product(){

    }

    public Product(int productId, String productName, double price, ProductPriceStratergy productPriceStratergy) {
        this.productId = productId;
        this.productName = productName;
        this.productPriceStratergy = productPriceStratergy;
        this.price = productPriceStratergy.calculatePrice(this, price);
    }

    /*
        We can also make product as abstract class, and create different products like, Electronic, Clothing, etc..
     */
}
