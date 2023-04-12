import java.security.Key;
import java.util.Random;

public class SortingTester {

    /**
     * Create a random keyValuePair Array.
     * @param size of the array.
     * @param max int of the largest key.
     * @return random array.
     */
    public static KeyValuePair[] randomArray(int size, int max){
        Random rand = new Random();
        KeyValuePair[] array = new KeyValuePair[size];

        for (int i = 0 ;i < size; i++){
            array[i] = new KeyValuePair(rand.nextInt(max),i);
        }

        return array;
    }
    public static boolean checkSort(ISort sorter, int size) {
        // Create key value pairs.
        KeyValuePair[] testArray = randomArray(size,size);

        // Do the sorting.
        long cost = sorter.sort(testArray);

        // Check the order.
        for (int i = 0;i < size-1;i++){
            if (testArray[i].compareTo(testArray[i+1]) == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStable(ISort sorter, int size) {
        // Create key value pairs.
        KeyValuePair[] testArray = new KeyValuePair[size];
        for (int i = 0;i<size;i++){
            testArray[i] = new KeyValuePair(2,i);
        }
        testArray[size-1] = new KeyValuePair(1,size-1);

        // Do the sorting
        long cost = sorter.sort(testArray);

        // Check the order
        for (int i = 1;i < size-1;i++){
            if (testArray[i].getValue() > testArray[i+1].getValue()){
                return false;
            }
        }
        return true;
    }

    public static void analyse(ISort sorter,int size){
        System.out.println(sorter+" Sort: "+checkSort(sorter,size)+" Stable: "+isStable(sorter,size));
        KeyValuePair[] worstArray  = new KeyValuePair[size];
        KeyValuePair[] bestArray = new KeyValuePair[size];
        KeyValuePair[] halfSorted = new KeyValuePair[size];
        KeyValuePair[] sameArray = new KeyValuePair[size];
        for (int i = 0;i <size;i++){
            worstArray[i] = new KeyValuePair(size-i,i);
            bestArray[i] = new KeyValuePair(i,i);
            halfSorted[i] = new KeyValuePair(i,i);
        }
        for (int i = size/2;i<size;i++){
            halfSorted[i] = new KeyValuePair(size-i,i);
        }
        System.out.println("Sort cost for worst case: "+ sorter.sort(worstArray));
        System.out.println("Sort cost for best case: "+ sorter.sort(bestArray));
        System.out.println("Sort cost for average case: "+ sorter.sort(randomArray(size,size)));
        System.out.println("Sort cost for half sorted array: "+ sorter.sort(halfSorted));
    }

    public static void main(String[] args) {
        ISort[] sorters = {new SorterA(),new SorterB(),new SorterC(),new SorterD(),new SorterE(),new SorterF()};
            for(ISort sorter : sorters){
                analyse(sorter,2000);
                System.out.println("");
            }
    }
}
