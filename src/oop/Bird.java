package oop;

public class Bird {

    //Fields
    private String name;
    private String color;
    private double avgLifespan;

    //basics.Methods
    //Setter methods
    public void setName(String name){
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAvgLifespan(double avgLifespan) {
        this.avgLifespan = avgLifespan;
    }

    //Getter methods

    public String getName(){
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getAvgLifespan() {
        return avgLifespan;
    }

    public void printBirdInfo(){
        System.out.println("Bird info: ");
        System.out.println("Name - " + name);
        System.out.println("Color - " + color);
        System.out.println("Average lifespan - " + avgLifespan);
    }

}
