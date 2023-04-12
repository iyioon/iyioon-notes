import java.util.*;

/**
 * This is the main class for your Markov Model.
 *
 * Assume that the text will contain ASCII characters in the range [1,255].
 * Ascii character 0 (the NULL character) will be treated as a non-character.
 *
 * Any such NULL characters in the original text should be ignored.
 *
 */
public class MarkovModel {

	// Use this to generatre random numbers as needed
	private Random generator = new Random();

	// HashTable
	private Hashtable<String,int []> model;

	// Order

	private int order;

	// This is a special symbol to indicate no character
	public static final char NOCHARACTER = (char) 0;

	/**
	 * Contructor for MarkovModel class.
	 *
	 * int order specifies the number of characters to identify for the Markov Model sequeuece.
	 * long seed specified the seed used by the random number generator
	 */
	public MarkovModel(int order, long seed) {
		// Initialize your class here
		model = new Hashtable<>();
		this.order = order;
		// Initialize the random number generator
		generator.setSeed(seed);
	}

	/**
	 *  Build the Markov Model based on the text string.
	 *  Count the frequency of each kgram in the text
	 */

	public void initializeText(String text) {
		model.clear(); // Clear previous model

		// Loop until the last order characters
		for (int i = 0; i < text.length() - order; i++) {

			// kgram starting at position i
			String key = text.substring(i, i + order);

			// Character after the Kgram
			char c = text.charAt(i + order);

			int[] array; // Array to store character frequencies
			if (model.containsKey(key)) {
				array = model.get(key);
			} else {
				array = new int[256];
				model.put(key, array);
			}

			array[c]++; // Store character frequency
			array[0]++; // Update total frequency
		}
	}

	/**
	 *  Returns the number of times sequence kgram appeared in the text
	 *  It should return an integer 0 or more.
	 */
	public int getFrequency(String kgram) {
		if (!model.containsKey(kgram)) {
			return 0;
		}
		return model.get(kgram)[0]; // Total frequency is stored at index 0
	}

	/*
	 * Gets number of times character c appeared following sequence kgram.
	 * It should return an integer 0 or more.
	 */
	public int getFrequency(String kgram, char c) {
		if (!model.containsKey(kgram)) {
			return 0;
		}
		return model.get(kgram)[c];
	}

	/**
	 * Generates the next character from the Markov Model.
	 * Return NOCHARACTER if the kgram is not in the table, or if there is no
	 * valid character following the kgram.
	 */
	char nextCharacter(String kgram) {
		// Total frequency of the kgram
		int sum = getFrequency(kgram);

		// Return the NOCHARACTER for invalid & does not exist
		if (sum == 0) {
			return NOCHARACTER;
		}

		// Random integer from [0,sum)
		int ran = generator.nextInt(sum);
		int index = 0;

		for (int i=1; i < 256; i++) {
			index += model.get(kgram)[i];
			if (ran < index) {
				return (char) i;
			}
		}

		return NOCHARACTER;
	}
}
