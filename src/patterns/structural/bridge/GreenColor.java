package patterns.structural.bridge;

public class GreenColor implements Color{
    @Override
    public void applyColor() {
        System.out.println("green");
    }
}
