package mythread;

class BankAccount{
    private int balance = 1000;
    public synchronized void withdraw(int amount, String name){
        if(balance >= amount){
            System.out.println(name +" is withdrawing" + amount);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println(e);
            }
            balance -= amount;
            System.out.println(name +" completed withdrawal. Remaining balance:"+ balance);
        } else {
            System.out.println(name+"attempted to withdraw"+ amount+"but insufficient balance");
        }
    }
}
class Customer extends Thread{
    private BankAccount account;
    private int amount;
    public Customer(BankAccount account,int amount, String name){
        super(name);
        this.account = account;
        this.amount = amount;
    }
    public void run(){
        account.withdraw(amount,Thread.currentThread().getName());
    }
}
 class TS{
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        Customer c1 = new Customer(account,700, "Alice");
        Customer c2 = new Customer(account, 500, "Bob");
        Customer c3 = new Customer(account, 400, "Charlie");

        c1.start();
        c2.start();
        c3.start();
    }
} 
    

