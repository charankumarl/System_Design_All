package LowLevelDesign.DesignOrderManagementSystem.Product;

public class DefaultPrice implements ProductPriceStratergy{

    @Override
    public double calculatePrice(Product product, double price) {
        return price;
    }
}
