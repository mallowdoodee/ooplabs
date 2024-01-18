public class Food {
    private final static int energy = 10;
    private static double price = 50;
    
    public static void setPrice(double price){
        if (Food.price < price){ 
            Food.price = price;
        } else {
            System.out.println("Cannot update the food price.");
        }
    }

    public static double getPrice(){ //remember how to crated METHOD
        return price;
    }
    
    public static int getEnergy(){
        return energy;
    }
}
