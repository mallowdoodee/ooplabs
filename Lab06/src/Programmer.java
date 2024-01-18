public class Programmer extends Employee{
    private int happiness;

    public void setHappiness(int happiness){
        this.happiness = happiness;
    }
    
    public int getHappiness(){
        return happiness;
    }
    
    public void coding(String str){
        if (getEnergy() >= 30){
            System.out.println("Your code is " + str);
            setEnergy(getEnergy() - 30);
            happiness -= 30;
        } else {
            System.out.println("Error Error Error");
            setEnergy(getEnergy() - 30);
            happiness -= 30;
        }
    }
    
    public void coding(char str){
        this.coding(String.valueOf(str));
    }
}
