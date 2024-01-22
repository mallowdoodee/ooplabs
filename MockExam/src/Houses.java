public abstract class Houses {
    private String name;
    private String color;
    
    public Houses(String name, String color){
        this.name = name;
        this.color = color;
    }
    
    public Houses(){
        this("", "");
    } 
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }
    
    @Override
    public String toString(){
        return ("[House] : " + name + " , Color : " + color);
    }
}
