package advanced.threads.firstexample;

import java.util.Random;

public class Bread implements Runnable{

    private String name;
    private int time;
    Random r = new Random();

    public Bread(String name){
        this.name = name;
        time = r.nextInt(5000);
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s is sleeping for %d\n", name,time);
            Thread.sleep(time);
            System.out.printf("%s is done\n",name);
        }catch (Exception e){
            System.out.println("test");
            e.printStackTrace();
        }
    }
}
