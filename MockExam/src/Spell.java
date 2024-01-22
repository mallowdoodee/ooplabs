public abstract class Spell {
    private int damage;
    private String name;
    
    public Spell(String name){
        this.damage = 0;
        this.name = name;
        
    }

    public Spell(){
        this("");
    }
    
    public void setDamage(int damage){
        this.damage = damage;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
