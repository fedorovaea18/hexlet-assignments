package exercise;

public class Flat implements Home {
    private double area;
    private double balconyArea;
    private Integer floor;

    public Flat (double area, double balconyArea, Integer floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
        
    @Override
    public double getArea() {
        return (this.area + this.balconyArea);
    }

    @Override
    public String toString() {
    	return  "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }

    @Override
    public String compareTo(Home another) {
        var compareResult = Double.compare(this.getArea(), another.getArea());
        if (compareResult > 0) {
            return "1";
        } else if (compareResult < 0) {
            return "-1";
        } else {
            return "0";
        }
    }     
}

