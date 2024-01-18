public class Account {
    public double balance;
    public String name;
    
    public void deposit(double b){
        if (b < 0){
            System.out.println("The balance variable must be greater then or equal to zero.");
        } else {
            balance += b;
        }
    }
    
    public double withdraw(double b){
        if (b < 0){
            System.out.println("The balance variable must be greater then or equal to zero.");
            b = 0;
        } else if (balance > b){
            balance -= b;
        } else {
            System.out.println("Your account balance is insufficient.");
            b = 0;
        }
        return b;
    }
    
    public void showInfo(){
        System.out.println("In " + name + " account, there is a balance equal to " + balance + " baht.");
    }
}
