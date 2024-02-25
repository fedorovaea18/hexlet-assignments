package exercise;
public class Segment {
    private Integer point1;
    private Integer point2;
    //private Shop shop;

    // Конструктор
    public Segment(Integer point1, Integer point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    
    public Integer getBeginPoint() {
        return point1;
    }
    
    public Integer getEndPoint() {
        return point2;
    }
    
    public Integer getMidPoint() {
        var midX = (point1.getX() + point2.getX()) / 2;
        var midY = (point1.getY() + point2.getY()) / 2;
        return new Point(midX, midY);
    }
}    

