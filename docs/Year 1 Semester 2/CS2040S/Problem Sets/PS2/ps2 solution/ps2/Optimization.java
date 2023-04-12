/**
 * The Optimization class contains a static routine to find the maximum in an array that changes direction at most once.
 */
public class Optimization {

    /**
     * A set of test cases.
     */
    static int[][] testCases = {
            {1,2,1,1,1,1,1},
            {1,4,3},
            {1,2,3,4,6,5,4,3,2,1},
            {-2,-3,-4,5,6,7,0,-5,-9},
            {},
            {1}
    };

    /**
     * Returns the maximum item in the specified array of integers which changes direction at most once.
     *
     * @param dataArray an array of integers which changes direction at most once.
     * @return the maximum item in data Array
     */
    public static int searchMax(int[] dataArray) {
        if(dataArray.length == 1) return dataArray[0]; // Invalid case.
        if(dataArray.length == 0) return 0; // Invalid case.

        int left = 0;
        int right = dataArray.length-1;
        int mid;
        // Max is set to either left or right
        int max = dataArray[left] > dataArray[right] ? dataArray[left] : dataArray [right];

        while (left <= right){
            mid = (left+right)/2;
            if(ispeak(dataArray,mid)){
                // Only change the max if the mid is greater.
                max =  dataArray[mid] > max ? dataArray[mid] : max;
                break;
            }else if(dataArray[mid] < dataArray[mid+1]){ // Search right half.
                left = mid+1;
            }else { // Search left half.
                right = mid-1;
            }
        }
        return max;
    }

    /**
     * Determines if a index of the dataArray is a peak.
     *
     * @param dataArray Given array.
     * @param index of the array which will be checked.
     * @return true if is peak. false otherwise.
     */
    public static boolean ispeak(int[] dataArray, int index){
        if(index == 0){
            return dataArray[index] > dataArray[index+1];
        }else if(index == dataArray.length-1){
            return dataArray[index] > dataArray[index-1];
        }else {
            return dataArray[index] > dataArray[index+1]
                    && dataArray[index] > dataArray[index-1];
        }
    }

    /**
     * A routine to test the searchMax routine.
     */
    public static void main(String[] args) {
        for (int[] testCase : testCases) {
            System.out.println(searchMax(testCase));
        }
    }
}
