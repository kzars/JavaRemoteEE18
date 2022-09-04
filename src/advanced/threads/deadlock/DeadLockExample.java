package advanced.threads.deadlock;

public class DeadLockExample {
    public static void main(String[] args) throws Exception{

        String r1 = "r1";
        String r2 = "r2";

        //Thread #1
        Thread t1 = new Thread(){
            @Override
            public void run() {

                synchronized (r1){
                    System.out.println("Thread #1 Locked String r1");
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (r2){
                        System.out.println("Thread #1 Locked String r2");
                    }
                }
            }
        };

        //Thread #2
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (r2){
                    System.out.println("Thread #2 Locked String r2");
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (r1){
                        System.out.println("Thread #2 Locked String 1");
                    }
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("End");

    }
}
