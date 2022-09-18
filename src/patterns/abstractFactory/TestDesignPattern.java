package patterns.abstractFactory;

public class TestDesignPattern {
    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory(){

        Computer pc = ComputerFactory.getComputer(new PCFactory("16 GB", "1 T", "3.1 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "5 T", "4.1 GHz"));
        System.out.println("AbstractFactory PC config: " + pc);
        System.out.println("AbstractFactory Server config: " + server);

    }

}
