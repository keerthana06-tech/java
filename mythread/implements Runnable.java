package mythread;

class MyRunnable impliments Runnable{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println("Runnable Thread:"+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start
    }
}
