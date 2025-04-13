package mythread;

 class MyThread extends Thread {
    private volatile boolean suspended = false;
    private volatile boolean stopped = false;
    public void run(){
        synchronized(this){
            while(!stopped){
                try{
                    while(suspended){
                        wait();
                    }
                    System.out.println(Thread.currentThread().getName()+"is running...");
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+"interrupted.");
                }
            }
            System.out.println(Thread.currentThread().getName()+"stopped.");
        }
    }
    public void suspendThread(){
        suspended = true;
    }
    public synchronized void resumeThread(){
        suspended = false;
        notify();
    }
    public void stopThread(){
        stopped = true;
    }
   }
    class ThreadControlDemo{
    public static void main(String[] args){
        MyThread t1 = new MyThread();
        t1.start();
        try{
            Thread.sleep(3000);

            System.out.println("Suspending thread...");
            t1.suspendThread();
            Thread.sleep(3000);

            System.out.println("Resuming thread...");
            t1.resumeThread();
            Thread.sleep(3000);

            System.out.println("stopping thread...");
            t1.stopThread();
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
   }

