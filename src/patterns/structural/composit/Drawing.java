package patterns.structural.composit;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape{

    private List<Shape> shapeList = new ArrayList<>();


    @Override
    public void draw(String fillColor) {
        for(Shape sh: shapeList){
            sh.draw(fillColor);
        }
    }


    //adding shape to drawing
    public void add(Shape s){
        this.shapeList.add(s);
    }

    //removing shape from drawing
    public void remove(Shape s){
        this.shapeList.remove(s);
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Clearing all the shapes from drawing");
        this.shapeList.clear();
    }

}
