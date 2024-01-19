public class Pigeous extends Bird {
    public Pigeous(){
        super("", 0);
        super.setPower(150);
    }
    
    public Pigeous(String name, int age){
        super(name, age);
        super.setPower(150);
    }
    
    @Override
    public void eat(Food f){
        this.setPower(this.getPower() + f.getPower() * 2);
    }
    
    @Override
    public void fly(){
        System.out.println(getName() + " fly fly ....");
    }
    
    @Override
    public void wingAttack(Animal a){
        a.setPower(a.getPower() - 5);
    }
    
    public void wingAttack(Animal a, int times){
        a.setPower(a.getPower() - (5 * times));
    }
}
