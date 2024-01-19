public class Meat extends Food{
    public Meat(){
        super();
        super.setName("");
    }
    
    @Override
    public int getPower(){
        return 50;
    }
}