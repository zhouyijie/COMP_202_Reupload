//Complete this class.
public class Vector2D {
    private double xPos;
    private double yPos;
    
    public Vector2D(double x, double y){
        xPos = x;
        yPos = y;
    }
    
    public double getX(){
        return this.xPos;
    }
    
    public double getY(){
        return this.yPos;
    }
    
    public double distance(Vector2D a){
        return java.lang.Math.sqrt((a.getY()-this.yPos)*(a.getY()-this.yPos)+(a.getX()-this.xPos)*(a.getX()-this.xPos));
    }
}
