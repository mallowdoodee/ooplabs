public class Car extends Vehicle {
    private String typeEngine;
    
    public void setTypeEngine(String t){
        typeEngine = t;
    }
    
    public String getTypeEngine(){
        return typeEngine;
    }
    
    public void setCarInfo(int s, String t, String y){
        setFuel(s);
        setTopSpeed(t);
        typeEngine = y;
    }
    
    public void move(){
        if (getFuel() < 50){
            System.out.println("Please add fuel.");
        } else {
            System.out.println("Move.");
            setFuel(getFuel() - 50);
        }
    }
    
    public void showCarInfo(){
        System.out.println("Car engine is " + typeEngine + ".");
        System.out.println("Fuel is " + getFuel() + " litre and Top Speed is " +
        getTopSpeed() + " m/s.");
    }
}
