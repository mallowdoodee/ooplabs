public class Seller extends Employee{
    public Food sell(Employee e){
        double foodprice = Food.getPrice();
        if (e.getWallet().getBalance() < foodprice){
            System.out.println("Your money is not enough.");
            return null;
        }else{
            e.getWallet().setBalance(e.getWallet().getBalance() - foodprice);
            getWallet().setBalance(getWallet().getBalance() + foodprice);//Seller Wallet Already Edited this line Reason No need to make new obj.
            return new Food();
        }
    }
}