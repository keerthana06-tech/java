package mythread;

class BankAccount{
    private int balance = 1000;
    public synchronized void withdraw(int amount, String name){
        while(balance < amount){
            System.out.println(name+"is waiting to withdraw"+amount+"due to insufficient balance");
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        balance -= amount;
        System.out.println(name+"successfully withdrew"+amount+"Remaining balance:"+balance);
    }
    public synchronized void deposit(int amount, String name){
        balance +=amount;
        System.out.println(name +"deposited"+ amount +".Updated balance:"+ balance);
        notifyAll();
    }
}
class Customer extends Thread{
    private BankAccount account;
    private int amount;
    private boolean isDepositor;
    public Customer(BankAccount account, int amount, String name, boolean isDepositor){
        super(name);
        this.account = account;
        this.amount = amount;
        this.isDepositor = isDepositor;
    }
    public void run(){
        if(isDepositor){
            account.deposit(amount, Thread.currentThread().getName());
        }else{
            account.withdraw(amount, Thread.currentThread().getName());
        }
    }
}

 class ThreadWaitNotifyDemo{
    public static void main(String[] args){
        BankAccount account = new BankAccount();
        Customer c1 = new Customer(account, 1200,"Alice",false);
        Customer c2 = new Customer(account, 500,"Bob",false);
        Customer depositor = new Customer(account, 1000,"Charlie",true);
        c1.start();
        c2.start();
        try{
            Thread.sleep(2000);
        } catch(InterruptedException e){
            System.out.println(e);
        }
        depositor.start();
    }
}
    

