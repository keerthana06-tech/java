package mythread;
class MyThread extends Thread{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread Running:"+i);
        }
    }
    public static void main(String[] args){
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}