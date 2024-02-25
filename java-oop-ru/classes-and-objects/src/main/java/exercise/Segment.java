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
        return (point2 + point1) / 2;
    }
}    
// BEGIN

// END
