package geometry;

public class Square extends Rectangular{
    private float side;

    public Square(float side){
        super(side,side);
        this.side = side;
    }

    public float getSide(){
        return side;
    }

}
