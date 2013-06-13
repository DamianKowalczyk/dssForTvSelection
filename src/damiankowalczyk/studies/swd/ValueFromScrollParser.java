package damiankowalczyk.studies.swd;

public class ValueFromScrollParser {
	// private static float[] valuesFromParse = {1.0f/9.0f, 1.0f/7.0f,
	// 1.0f/5.0f, 1.0f/3.0f, 1.0f, 3.0f, 5.0f, 7.0f, 9.0f}; // this order was
	// wrong
	private static float[] valuesFromParse = { 9.0f, 7.0f, 5.0f, 3.0f, 1.0f,
			1.0f / 3.0f, 1.0f / 5.0f, 1.0f / 7.0f, 1.0f / 9.0f };

	public static float parseValue(int value) {
		return valuesFromParse[value];
	}
}
