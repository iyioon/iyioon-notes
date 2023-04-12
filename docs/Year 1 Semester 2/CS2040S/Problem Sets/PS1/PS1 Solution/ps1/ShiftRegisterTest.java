import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ShiftRegisterTest
 * @author dcsslg
 * Description: set of tests for a shift register implementation
 */
public class ShiftRegisterTest {
    /**
     * Returns a shift register to test.
     * @param size
     * @param tap
     * @return a new shift register.
     */
    ILFShiftRegister getRegister(int size, int tap) {
        return new ShiftRegister(size, tap);
    }


    /**
     * Tests shift with simple example.
     */
    @Test
    public void testShift1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = { 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        r.setSeed(seed);
        int[] expected = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        for (int i = 0; i < 10; i++) {
            assertEquals(expected[i], r.shift());
        }
    }

    /**
     * Tests generate with simple example.
     */
    @Test
    public void testGenerate1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = { 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        r.setSeed(seed);
        int[] expected = { 6, 1, 7, 2, 2, 1, 6, 6, 2, 3 };
        for (int i = 0; i < 10; i++) {
            assertEquals("GenerateTest", expected[i], r.generate(3));
        }
    }

    /**
     * Tests register of length 1.
     */
    @Test
    public void testOneLength() {
        ILFShiftRegister r = getRegister(1, 0);
        int[] seed = { 1 };
        r.setSeed(seed);
        int[] expected = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
        for (int i = 0; i < 10; i++) {
            assertEquals(expected[i], r.generate(3));
        }
    }

    /**
     * Tests with erroneous seed.
     */
    @Test
    public void testError() {
        ILFShiftRegister r = getRegister(4, 1);
        int[] seed = { 1, 0, 0, 0, 1, 1, 0 };
        try {
            r.setSeed(seed);
        }catch (IllegalArgumentException e) {
            assertEquals("Invalid Seed",e.getMessage());
        }
    }

    /**
     * Test if non binary array produces an error.
     */
    @Test
    public void testSeedFormat() {
        ILFShiftRegister r = getRegister(4, 1);
        int[] seed = { 1, 3, 0, 0, 1, 1, 0 };
        try {
            r.setSeed(seed);
        }catch (IllegalArgumentException e) {
            assertEquals("Invalid Seed",e.getMessage());
        }
    }

    /**
     * Test invalid size.
     */
    @Test
    public void testSize() {
        try {
            ILFShiftRegister r = getRegister(0, 1);
        } catch (IllegalArgumentException e){
            assertEquals("Invalid tap or size",e.getMessage());
        }
    }

    /**
     * Test invalid tap.
     */
    @Test
    public void testTap() {
        try {
            ILFShiftRegister r = getRegister(10, 12);
        } catch (IllegalArgumentException e){
            assertEquals("Invalid tap or size",e.getMessage());
        }
    }

    @Test
    public void testtest(){
        ILFShiftRegister r = getRegister(10, 2);
        r.setSeed("Hello");
        System.out.println("");
        System.out.println("10010001100101110110011011001101111");
    }
}
