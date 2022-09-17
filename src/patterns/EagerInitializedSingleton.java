package patterns;

public class EagerInitializedSingleton {

    //Creating a field that represents an instance oh this class
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Creating private constructor to avoid calling it outside the class definition
    private EagerInitializedSingleton(){

    }

    //Creating a method to get a class instance
    public static EagerInitializedSingleton getInstance(){
        return instance;
    }

}
