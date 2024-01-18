public class Product<T> {
    private T details;
    private double price;
    
    public T getDetails(){
        return details;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setDetails(T details){
        this.details = details;
    }
    
    public void setPrice(double price){
        this.price= price;
    }
    
    public Product(T details, double price){
        this.details = details;
        this.price = price;
    }
}
