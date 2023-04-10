/**
 * CS2030S Lab 0: Point.java
 * Semester 1, 2022/23
 *
 * <p>The Point class encapsulates a point on a 2D plane.
 *
 * @author XXX
 */
class Point {
  // TODO
  private double x;
  private double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double getx(){
    return this.x;
  }

  public double gety(){
    return this.y;
  }
  @Override
  public String toString(){
    return "("+x+", "+y+")";
  }

}
