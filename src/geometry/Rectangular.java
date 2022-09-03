package geometry;

public class Rectangular {

    protected float length;
    protected float width;

    public Rectangular(float length, float width){
        this.length = length;
        this.width = width;
    }

    public void area(){
        System.out.println("Area: " + length* width);
    }

    public void perimeter(){
        System.out.println("Perimeter: " + 2 * (length+width));
    }

}
