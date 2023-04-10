import cs2030s.fp.Immutator
import cs2030s.fp.InfiniteList
import cs2030s.fp.Constant

 Immutator<Integer, Integer> incr = x -> {
 System.out.println("   " + x + " + 1 = " + (x + 1));
  return x + 1;
}
Immutator<Boolean, Integer> lessThan0 = x -> {
  System.out.println("     " + x + " < 0 = " + (x < 0));
  return x < 0;
 }
Immutator<Boolean, Integer> lessThan2 = x -> {
 System.out.println("     " + x + " < 2 = " + (x < 2));
  return x < 2;
}
Immutator<Boolean, Integer> lessThan5 = x -> {
  System.out.println("     " + x + " < 5 = " + (x < 5));
  return x < 5;
 }
Immutator<Boolean, Integer> lessThan10 = x -> {
 System.out.println("     " + x + " < 10 = " + (x < 10));
  return x < 10;
 }
Immutator<Boolean, Integer> isEven = x -> {
  System.out.println("     " + x + " % 2 = " + (x % 2));
  return x % 2 == 0;
 }
 <T> T run(Constant<T> c) {
   try {
    return c.init();
  } catch (Exception e) {
    System.out.println(e);
    return null;
   }
 }
