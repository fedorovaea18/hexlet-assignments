package exercise;

public class Cottage implements Home {
    private double area;
    private Integer floorCount;

    public Cottage(double area, Integer floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return  floorCount + " этажный коттедж площадью " + area + " метров";
    }

    @Override
    public String compareTo(Home another) {
        double anotherArea = another.getArea();
        if (this.area > anotherArea) {
            return "1";
        } else if (this.area < anotherArea) {
            return "-1";
        } else {
            return "0";
        }
    }
}

