import java.util.Random;

class RandomPoint extends Point{
  private static Random rand = new Random(1);

  public RandomPoint(double minX, double maxX, double minY, double maxY){
    super(minX+(maxX-minX)*rand.nextDouble(),minY+(maxY-minY)*rand.nextDouble());
  }

  public static void setSeed(int seed){
    rand.setSeed(seed);
  }
}

// TODO
