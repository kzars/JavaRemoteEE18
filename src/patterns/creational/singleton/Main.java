package patterns.creational.singleton;

public class Main {
    public static void main(String[] args) {

        ClassicalClass c1 = new ClassicalClass();
        ClassicalClass c2 = new ClassicalClass();

        c1.setName("Toby");
        System.out.println(c1.getName());

        System.out.println(c2.getName());

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        EagerInitializedSingleton e1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton e2 = EagerInitializedSingleton.getInstance();

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        e1.setName("Mike");
        System.out.println(e1.getName());

        System.out.println(e2.getName());

        e2.setName("Carl");
        System.out.println(e1.getName());

        System.out.println(e2.getName());



    }
}
