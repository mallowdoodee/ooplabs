public class Vehicle {
    private int fuel;
    private String topSpeed;
    
    protected void setFuel(int i){
        fuel = i;
    }
    
    protected int getFuel(){
        return fuel;
    }
    
    protected void setTopSpeed(String n){
        topSpeed = n;
    }
    
    protected String getTopSpeed(){
        return topSpeed;
    }
    
    public void showInfo(){
        System.out.println("Fuel is " + getFuel() + " litre and Top Speed is " +
                getTopSpeed() + " m/s.");
    }
}
