public class Player {
    private Houses houses;
    private int hp = 20;
    private int mana = 50;
    private final int attackDamage = 2;
    private final String name;
    
    @Override
    public String toString(){
        return ("[Player] : " + name + " HP: " + hp + " Mana: " + mana + " || " + houses);
    }
    
    public Player(String name){
        this.name = name;
    }
    
    public Player(String name, int hp){
        this.name = name;
        this.hp = hp;
    }
    
    public void setHouses(Houses houses){
        this.houses = houses;
    }
    
    public Houses getHouses(){
        return houses;
    }
    
    public void setHp(int hp){
        if (hp < 0){
            this.hp = 0;
        } else if (hp > 20){
            this.hp = 20;
        } else {
            this.hp = hp;
        }
    }
    
    public int getHp(){
        return hp;
    }
    
    public void setMana(int mana){
        if (mana < 0){
            this.mana = 0;
        } else if (mana > 50){
            this.mana = 50;
        } else {
            this.mana = mana;
        }
    }
    
    public int getMana(){
        return mana;
    }
    
    public int getAttackDamage(){
        return attackDamage;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean equals(Player player){
        return ((this.name.equals(player.name)) && (this.houses == player.houses));
    }
    
    public void attack(Player target, Spell spell){
       if (houses.getName().equals("Hufflepuff")){
           Hufflepuff h = new Hufflepuff();
           h.attackSpell(this, target, spell);
       } else {
           Gryffindor g = new Gryffindor();
           g.attackSpell(this, target, spell);
       }
       
       if (target.getHp() == 0){
           System.out.println("[DEAD]:" + target.getName() + " was killed by " + this.name);
       }
    }
    
    public void protectFromPlayer(Player target){
        if (houses.getName().equals("Hufflepuff")){
           Hufflepuff h = new Hufflepuff();
           h.defense(this, target);
       } else {
            Gryffindor g = new Gryffindor();
            g.defense(this, target);
        }
    }
}
