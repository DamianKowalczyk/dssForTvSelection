package damiankowalczyk.studies.swd;

public class AhpEngine {
	float[][] preferencesMatrix;
	float[][][] matrixes; // all matrixes as
	float[][] v;
	float vecC[];
	float[] vectorS0;
	float[][] vectors;
	float[][] c;
	float[] c0;
	float[] vectorR;

	private float consistencyCoefficientLimit = 0.1f;

	private float[] randomConsistencyIndexes = { 10.0f, 10.0f, 10.0f, 0.58f, 0.9f,
			1.12f, 1.24f, 1.32f, 1.41f, 1.45f, 1.51f };	// for matrix size <= 

	public AhpEngine() {
	}

	public void calculate() {
		preferencesMatrix = fillMatrix(preferencesMatrix);
		// c0=new float[preferencesMatrix.length];
		c0 = calculateC(preferencesMatrix);
		vectorS0 = new float[preferencesMatrix.length];
		vectorS0 = calculateVectorS(normalizeMatrix(preferencesMatrix));
		checkConsistency(c0, vectorS0);

		c = new float[matrixes.length][matrixes[0].length];
		vectors = new float[matrixes.length][matrixes[0].length];

		for (int i = 0; i < matrixes.length; i++) {
			//
			matrixes[i] = fillMatrix(matrixes[i]);

			System.out.println(matrixes[i][0][2]);
			c[i] = calculateC(matrixes[i]);
			System.out.println(c[i][0]);
			vectors[i] = calculateVectorS(normalizeMatrix(matrixes[i]));
			System.out.println("s" + i + ": ");
			System.out.println(vectors[i][0]);

			checkConsistency(c[i], vectors[i]);
		}

		vectorR = calculateVectorR(fillMatrixV(vectors), vectorS0);

	}
	
	public int[] calculateOrder(){
		//float[] gradeForEachTV = calculateVectorR(, s0);
		
		
		return null;
	}

	private float[] calculateVectorR(float[][] v, float[] s0) {
		float[] result = new float[s0.length];
		float sum;
		for (int i = 0; i < s0.length; i++) {
			sum = 0.0f;
			for (int j = 0; j < v.length; j++) {
				sum += v[i][j] * s0[j];
			}
			result[i] = sum;
		}
		return result;
	}
	
	

	private float[][] fillMatrix(float[][] matrix) {
		float[][] result;
		result = matrix;
		addOnes(result);
		for (int i = 0; i < result.length; i++) {
			for (int j = i + 1; j < result.length; j++) {
				result[j][i] = 1 / result[i][j];
			}
		}

		return result;
	}

	private float[][] fillMatrixV(float[]... s) {
		float[][] v = new float[s.length][s[0].length];
		for (int i = 0; i < v.length; i++) {
			v[i] = s[i];
		}
		return v;
	}	

	private float[] calculateC(float[][] matrix) {
		float[] c = new float[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			c[i] = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				c[i] += matrix[j][i];
			}
		}
		return c;
	} // checked

	private float[][] normalizeMatrix(float[][] matrix) {
		float[] c = calculateC(matrix);
		float[][] result = new float[matrix.length][matrix.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[j][i] = matrix[j][i] / c[i];
			}
		}
		return result;
	} // checked

	private float[] calculateVectorS(float[][] matrix) {
		float[] resultVector = new float[matrix.length];
		float sumValuesInRow;
		for (int i = 0; i < matrix.length; i++) {
			sumValuesInRow = 0.0f;
			for (int j = 0; j < matrix[i].length; j++) {
				sumValuesInRow += matrix[i][j];
			}
			resultVector[i] = sumValuesInRow / matrix.length;
		}
		return resultVector;
	} // checked

	private boolean checkConsistency(float[] c, float[] vecS) {
		float randomConsistencyIndex = returnRandomConsistencyIndex(c.length);
		float lambdaMax = calculateLambdaMax(c, vecS);
		float consistencyIndex = (lambdaMax - c.length) / (c.length - 1);
		float consistencyRatio = consistencyIndex / randomConsistencyIndex;

		return (consistencyRatio < consistencyCoefficientLimit) ? true : false;
	}

	private float calculateLambdaMax(float[] vectorC, float[] vectorS) {
		float result = 0.0f;
		for (int i = 0; i < vectorC.length; i++) {
			result += vectorC[i] * vectorS[i];
		}
		return result;
	} // checked

	private void addOnes(float[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = 1.0f;
		}
	}

	private float returnRandomConsistencyIndex(int sizeOfMatrix) {
		return randomConsistencyIndexes[sizeOfMatrix];
	}

	public void setMatrixes(float[][][] matrixes) {
		this.matrixes = matrixes;
		for (int i = 0; i < this.matrixes.length; i++) {
			fillMatrix(this.matrixes[i]);
		}

		printAllFeatureMatrixes(this.matrixes);
	}

	public float[][] getPreferencesMatrix() {
		return preferencesMatrix;
	}

	public void setPreferencesMatrix(float[][] preferencesMatrix) {
		this.preferencesMatrix = preferencesMatrix;
		this.fillMatrix(this.preferencesMatrix);
	}

	public float[][][] getMatrixes() {
		return matrixes;
	}

	public boolean checkConsistencyOfPreferenceMatrix() {
		c0 = calculateC(preferencesMatrix);
		vectorS0 = calculateVectorS(normalizeMatrix(preferencesMatrix));
		return checkConsistency(c0, vectorS0);
	}

	public boolean[] checkConsistencyOfAllFeatureMatrixes() {
		boolean[] consistencyOfAllFeatureMatrixes = new boolean[matrixes.length];

		float[] c;
		vectors = new float[matrixes.length][];

		for (int i = 0; i < matrixes.length; i++) {
			c = calculateC(matrixes[i]);
			vectors[i] = calculateVectorS(normalizeMatrix(matrixes[i]));

			consistencyOfAllFeatureMatrixes[i] = checkConsistency(c, vectors[i]);
		}

		return consistencyOfAllFeatureMatrixes;
	}

	public static void printAllFeatureMatrixes(float[][][] matrixes) {
		for (int i = 0; i < matrixes.length; i++) {
			printMatrix(matrixes[i]);
		}
	}

	// only for tests
	public static void printMatrix(float[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.format("%.2f  ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}