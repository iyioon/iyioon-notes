import java.util.Scanner;

/**
 * CS2030S Lab 0: Estimating Pi with Monte Carlo
 * Semester 1, 2022/23
 *
 * <p>This program takes in two command line arguments: the 
 * number of points and a random seed.  It runs the
 * Monte Carlo simulation with the given argument and print
 * out the estimated pi value.
 *
 * @author XXX 
 */
import java.util.*;
class Lab0 {

  public static double estimatePi(long numOfPoints, int seed){
    RandomPoint.setSeed(seed);
    double x = 0.5;
    double y = 0.5;
    double r = 0.5;
    Point center = new Point(x,y);
    Circle circle = new Circle(center,r);
    double k = 0;
    RandomPoint randomp;

    for(int i = 0;i<numOfPoints;i++){
      randomp = new RandomPoint(x-r,x+r,y-r,y+r);
      if(circle.contains(randomp)){
        k++;
      }
    }
    return (4*k)/numOfPoints;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfPoints = sc.nextInt();
    int seed = sc.nextInt();

    double pi = estimatePi(numOfPoints, seed);

    System.out.println(pi);
    sc.close();
  }
}
