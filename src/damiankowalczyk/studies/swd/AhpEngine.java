package damiankowalczyk.studies.swd;

public class AhpEngine {
	float[][] preferencesMatrix;
	float[][][] matrices;	// all matrixes as 
	float[][] v;
	float vecC[];
	float[] vectorS0;
	float[][] vectors;
	float[][] c;
	float[] c0;
	float[] vectorV;

	private float[] randomConsistencyIndexes = { 0.0f, 0.0f, 0.0f, 0.58f, 0.9f,
			1.12f, 1.24f, 1.32f, 1.41f, 1.45f, 1.51f };

	public AhpEngine(float[][] preferencesMatrix, float[][]... matrix) {
		this.preferencesMatrix = preferencesMatrix;
		this.matrices = matrix;
	}

	public void calculate() {
		preferencesMatrix = fillMatrix(preferencesMatrix);
		// c0=new float[preferencesMatrix.length];
		c0 = calculateC(preferencesMatrix);
		vectorS0 = new float[preferencesMatrix.length];
		vectorS0 = calculateVectorS(normalizeMatrix(preferencesMatrix));
		checkConsistency(c0, vectorS0);

		c = new float[matrices.length][matrices[0].length];
		vectors = new float[matrices.length][matrices[0].length];

		for (int i = 0; i < matrices.length; i++) {
			//
			matrices[i] = fillMatrix(matrices[i]);

			System.out.println(matrices[i][0][2]);
			c[i] = calculateC(matrices[i]);
			System.out.println(c[i][0]);
			vectors[i] = calculateVectorS(normalizeMatrix(matrices[i]));
			System.out.println("s" + i + ": ");
			System.out.println(vectors[i][0]);

			checkConsistency(c[i], vectors[i]);

		}

		vectorV = calculateVectorV(fillMatrixV(vectors), vectorS0);

		// for (int i=0; i<vectorV.length;i++){

		// System.out.println("wektor w pozycja "+i+": "+vectorV[i]);
		// }

	}

	private float[] calculateVectorV(float[][] v, float[] s0) {
		float[] result = new float[s0.length];
		for (int i = 0; i < s0.length; i++) {
			for (int j = 0; j < v.length; j++) {
				result[i] += v[i][j] * s0[j];
			}
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

	private void showValues() {
		System.out.println("Normalized Matrix: ");
		for (int i = 0; i < preferencesMatrix.length; i++) {
			for (int j = 0; j < preferencesMatrix[i].length; j++) {
				System.out.print(preferencesMatrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("Preference Vector: ");

		for (int i = 0; i < vectorS0.length; i++) {
			System.out.print(vectorS0[i]);
		}
		System.out.println("");
	}

	private float[] calculateC(float[][] matrix) {
		float[] c = new float[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				c[i] += matrix[j][i];
			}
		}
		return c;
	}

	private float[][] normalizeMatrix(float[][] matrix) {
		float[] c = calculateC(matrix);
		float[][] result = matrix;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[j][i] /= c[i];
			}
		}
		return result;
	}

	private float[] calculateVectorS(float[][] matrix) {
		float[] resultVector = new float[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				resultVector[i] += matrix[i][j];
			}
			resultVector[i] /= matrix[i].length;
		}
		return resultVector;
	}

	private void checkConsistency(float[] c, float[] vecS) {
		float consistencyRatio;
		float consistencyIndex = 0.0f;
		float lambdaMax = 0.0f;
		float randomConsistencyIndex = returnRandomConsistencyIndex(c.length);
		lambdaMax = calculateLambdaMax(c, vecS);
		consistencyIndex = (lambdaMax - c.length) / (c.length - 1);
		consistencyRatio = consistencyIndex / randomConsistencyIndex;
                
                
//		if (consistencyRatio > 0.1) {
//			Log.v("Macierz", " niesp�jna");
//		} else {
//			Log.v("Macierz", " ok");
//		}
	}

	private float calculateLambdaMax(float[] vectorC, float[] vectorS) {
		float result = 0.0f;
		for (int i = 0; i < vectorC.length; i++) {
			result += vectorC[i] * vectorS[i];
		}
		return result;
	}

	private void addOnes(float[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][i] = 1.0f;
		}
	}

	private float returnRandomConsistencyIndex(int sizeOfMatrix) {
		return randomConsistencyIndexes[sizeOfMatrix];
	}
}