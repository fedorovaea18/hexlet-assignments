package exercise;

public class Cottage implements Home {
    private double area;
    private Integer floorCount;

    public Cottage (double area, Integer floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
        
    @Override
    public String toString() {
    	return  floorCount + "этажный коттедж площадью" + area + "метров";
    }

    @Override
    public String compareTo(Home another) {
        var compareResult = Integer.compare(this.area(), another.area());
        if (compareResult > 0) {
            return "1";
        } else if (compareResult < 0) {
            return "-1";
        } else {
            return "0";
        }
    }     
}

