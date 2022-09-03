package geometry;

public class Geometry {
    public static void main(String[] args) {

        Rectangular rectangular = new Rectangular(5,6);
        rectangular.area();
        rectangular.perimeter();

        Square square = new Square(6);
        square.area();
        square.perimeter();
        System.out.println(square.getSide());

    }
}
