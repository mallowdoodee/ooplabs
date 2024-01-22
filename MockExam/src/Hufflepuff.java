public class Hufflepuff extends Houses implements Magicable{
    public Hufflepuff(){
        super("Hufflepuff", "YELLOW");
    }
    
    @Override
    public void attackSpell(Player player, Player target, Spell spell){
        if (spell.getDamage() == 5){
            player.setMana(player.getMana() - 3);
        } else {
            player.setMana(player.getMana() - 4);

        }     
        target.setHp(target.getHp() - (spell.getDamage() + player.getAttackDamage()));
        System.out.println("[" + player.getName() +"]: use spell " + spell.getName() + "!");
    }
    
    @Override
    public void defense(Player player, Player damage){
        //defense attrack from Player damage
        player.setHp(player.getHp() + 4);
        player.setMana(player.getMana() + 3);
        System.out.println("[" + player.getName() + "]: Protego !");
    }
}
