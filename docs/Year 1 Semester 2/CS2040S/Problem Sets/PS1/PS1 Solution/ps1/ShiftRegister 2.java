import java.util.ArrayList;

/**
 * class ShiftRegister
 *
 * @author Description: implements the ILFShiftRegister interface.
 */
public class ShiftRegister implements ILFShiftRegister {

    /** Size of the ShiftRegister. */
    private int size;

    /** One of the bits location. */
    private int tap;

    /** Array of the seed with LSB on index 0. */
    private int[] seed;

    /**
     * Constructor initializes the shift register.
     * 
     * @param size of the register.
     * @param tap location on the array used for XOR.
     */
    ShiftRegister(int size, int tap) {
        if (tap < 0 || tap > size || size < 1){
            throw new IllegalArgumentException("Invalid tap or size");
        }
        this.size = size;
        this.tap = tap;
    }

    /**
     * Sets the shift register to the specified initial seed.
     * The seed is only set when the array consists of only 1 and 0.
     * And when the size of the array is equal to the shiftregister size.
     * 
     * @param seed Array where LSB is on index 0.
     */
    @Override
    public void setSeed(int[] seed) {
        if (!checkBinary(seed) || !checkSeedSize(seed)) {
            throw new IllegalArgumentException("Invalid Seed");
        }
        this.seed = seed;
    }

    @Override
    public void setSeed(String input){
        ArrayList<Integer> binary = new ArrayList<>();
        char[] character  = input.toCharArray();

        for(int i = 0;i<character.length;i++){
            for (int k = 0; k<Integer.toBinaryString(character[i]).length();k++){
                binary.add(Character.getNumericValue(Integer.toBinaryString(character[i]).charAt(k)));
            }
        }
        this.seed = binary.stream().mapToInt(x->x).toArray();
    }

    /**
     * Check valid seed size.
     * 
     * @param array of the seed.
     * @return false if invalid, vice versa.
     */
    public boolean checkSeedSize(int[] array) {
       if (array.length != this.size){
           return false;
       }
       return true;
    }

    /**
     * Check every element in the array is 0 or 1.
     * 
     * @param array of the seed.
     * @return true if binary. Vice versa.
     */
    public boolean checkBinary(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i] != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Executes one shift step.
     * 
     * @return The least significant bit.
     */
    @Override
    public int shift() {
        int temp = this.seed[0];
        int temp2;
        this.seed[0] = this.seed[size-1]^this.seed[this.tap];
        for(int i = 1;i<this.size;i++) {
            temp2 = this.seed[i];
            this.seed[i] = temp;
            temp = temp2;
        }
        return this.seed[0];
    }

    /**
     * Extracts k bits from the shift register.
     * 
     * @param k The number of shift.
     * @return Convert the k bits from binary into an integer.
     */
    @Override
    public int generate(int k) {
        int res[] = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = this.shift();
        }
        return toDecimal(res);
    }

    /**
     * Turn binary array into decimal.
     * 
     * @param array of the binary.
     * @return integer.
     */
    private int toDecimal(int[] array) {
        int res = 0;
        int pow = 1;
        for (int i = array.length-1;i>=0;i--){
            if (array[i] == 1){
                res += pow;
            }
            pow *= 2;
        }
        return res;
    }
}
