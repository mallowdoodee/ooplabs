public class Main {
    public static void main(String[] args) {
        Product<Electronics> electronicProduct = new Product<>(new Electronics(24),1000);
        Product<FoodProduct> foodProduct = new Product<>(new FoodProduct("2022-12-31"),200);
        System.out.println("electronicProduct : " + electronicProduct.getPrice()+" and its warrantyPeriod : " + electronicProduct.getDetails().getWarrantyPeriod());
        System.out.println("foodProduct : " + foodProduct.getPrice()+" and its expirationDate : " + foodProduct.getDetails().getExpirationDate());
    }
}