public abstract class Food {
    protected String name;
    
    public Food(){
        this.name = "";// Cannot use this() bcause this is default constructor
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public abstract int getPower();
}
