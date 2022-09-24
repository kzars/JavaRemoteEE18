package patterns.creational.singleton;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    private StaticBlockSingleton(){

    }
    static {
        try {
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
