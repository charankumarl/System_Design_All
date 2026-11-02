package LowLevelDesign.DesignOrderManagementSystem.Product;

public class FestivalTimePrice implements ProductPriceStratergy {

    @Override
    public double calculatePrice(Product product, double price) {
        return price - (price * 0.2); // 20% discount during festival time
    }
}
