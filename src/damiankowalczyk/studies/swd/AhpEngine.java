package damiankowalczyk.studies.swd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class AhpEngine {
	float[][] preferencesMatrix;
	float[][][] matrixes; // all matrixes as
	
	private float consistencyCoefficientLimit = 0.1f;

	private float[] randomConsistencyIndexes = { 10.0f, 10.0f, 10.0f, 0.58f,
			0.9f, 1.12f, 1.24f, 1.32f, 1.41f, 1.45f, 1.51f }; // for matrix size
																// <=

	public AhpEngine() {
	}

	
	public int[] calculateOrderWhenMatrixCoherent() {
		float[] vectorS0 = calculateVectorS(normalizeMatrix(preferencesMatrix));
		float[][] vectorsS = new float[preferencesMatrix.length][];	// as many as many features we have

		for (int i = 0; i < matrixes.length; i++) {
			vectorsS[i] = calculateVectorS(normalizeMatrix(matrixes[i]));
		}

		float[] vectorR = calculateVectorR(vectorsS, vectorS0);

		return indexesInOrderNewer(vectorR);
	}
	
	/*float[] vectorS;
	vectorS = ahpEngine.calculateVectorS(prefMatrix);
	
	float[][] vectorsS = new float[otherMatrixes.length][];
	for (int i = 0; i < otherMatrixes.length; i++) {
		vectorsS[i] = ahpEngine.calculateVectorS(otherMatrixes[i]);		
	}	
	
	float[] vectorR =  ahpEngine.calculateVectorR(vectorsS, vectorS);
	int[] indexesInOrder;
	indexesInOrder = ahpEngine.indexesInOrderNewer(vectorR);*/
	
	private int[] indexesInOrderNewer(float[] vectorR) {		
		PairsValueAndIndex[] pairs = new PairsValueAndIndex[vectorR.length];
				
		for (int i = 0; i < vectorR.length; i++){			
			pairs[i] = new PairsValueAndIndex(vectorR[i], i);
		}

		Arrays.sort(pairs, Collections.reverseOrder());

		int[] result = new int[vectorR.length];
		int index;
		for (int i = 0; i < result.length; i++) {			
			result[i] = pairs[i].index;
		}
		return result;
	} //checked
	
	
	private float[] calculateVectorR(float[][] vectorsS, float[] s0) {
		float[] result = new float[vectorsS[0].length];
		float sum;
		for (int i = 0; i < vectorsS[0].length; i++) {
			sum = 0.0f;
			for (int j = 0; j < vectorsS.length; j++) {
				sum += vectorsS[j][i] * s0[j];
			}
			result[i] = sum;
		}
		return result;
	} // checked and corrected

	
	 

	/**
	 * this method will add 1.0 on the diagonal of matrix and fill the second
	 * half of matrix based on firs half
	 * 
	 * @param matrix
	 * @return
	 */
	private float[][] completeMatrix(float[][] matrix) {
		float[][] result;
		result = matrix;
		addOnes(result);
		for (int i = 0; i < result.length - 1; i++) {
			for (int j = i + 1; j < result.length; j++) {
				result[j][i] = 1 / result[i][j];
			}
		}
		return result;
	} // checked and corrected

	private float[] calculateC(float[][] matrix) {
		float[] c = new float[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			c[i] = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				c[i] += matrix[j][i];
			}
		}
//		printVector(c);
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
//		printMatrix(result);
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
//		printVector(resultVector);
		return resultVector;
	} // checked

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
	} // checked

	private float returnRandomConsistencyIndex(int sizeOfMatrix) {
		return randomConsistencyIndexes[sizeOfMatrix];
	} // checked

	public void setMatrixes(float[][][] matrixes) {
		this.matrixes = matrixes;
		for (int i = 0; i < this.matrixes.length; i++) {
			completeMatrix(this.matrixes[i]);
		}

//		printAllFeatureMatrixes(this.matrixes);
	} // checked

	public float[][] getPreferencesMatrix() {
		return preferencesMatrix;
	} // checked

	public void setPreferencesMatrix(float[][] preferencesMatrix) {
		this.preferencesMatrix = preferencesMatrix;
		this.completeMatrix(this.preferencesMatrix);
		
//		printMatrix(this.preferencesMatrix);
	} // checked

	public float[][][] getMatrixes() {
		return matrixes;
	} // checked

	private boolean checkConsistency(float[] c, float[] vecS) {
		float randomConsistencyIndex = returnRandomConsistencyIndex(c.length);
		float lambdaMax = calculateLambdaMax(c, vecS);
		float consistencyIndex = (lambdaMax - c.length) / (c.length - 1);
		float consistencyRatio = consistencyIndex / randomConsistencyIndex;
		
		System.out.println("CR = "+consistencyRatio);
		return (consistencyRatio < consistencyCoefficientLimit) ? true : false;
	} // checked

	public boolean checkConsistencyOfPreferenceMatrix() {
		float[] c0 = calculateC(preferencesMatrix);
		float[] vectorS0 = calculateVectorS(normalizeMatrix(preferencesMatrix));
		return checkConsistency(c0, vectorS0);
	} // checked

	public boolean[] checkConsistencyOfAllFeatureMatrixes() {
		boolean[] consistencyOfAllFeatureMatrixes = new boolean[matrixes.length];

		float[] c;
		float[] vectorS = new float[matrixes.length];

		for (int i = 0; i < matrixes.length; i++) {
			c = calculateC(matrixes[i]);
			vectorS = calculateVectorS(normalizeMatrix(matrixes[i]));

			consistencyOfAllFeatureMatrixes[i] = checkConsistency(c, vectorS);
		}
		return consistencyOfAllFeatureMatrixes;
	} // checked

	// prints methods only for test
	// ************************************************
	public static void printVector(float[] vector){
		for (int i = 0; i < vector.length; i++) {
			System.out.format("%.2f  ", vector[i]);		
		}
		System.out.println();
	}
	
	public static void printAllFeatureMatrixes(float[][][] matrixes) {
		for (int i = 0; i < matrixes.length; i++) {
			printMatrix(matrixes[i]);
		}
	}

	public static void printMatrix(float[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.format("%.2f  ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		AhpEngine ahpEngine = new AhpEngine();
		
		float[][] prefMatrix = {
					{ 1,   3,  7,   9},
					{1.0f/3,  1,  3,   7},
					{1.0f/7, 1.0f/3, 1,   3},
					{1.0f/9, 1.0f/7, 1.0f/3, 1}
			};
		
		float[][] bezp = {
				{1,1,7},
				{1,1,3},
				{1.0f/7, 1.0f/3,1}
		};
		
		float[][] cena = {
				{1,1.0f/5,1},
				{5,1,3},
				{1, 1.0f/3,1}
		};
		
		float[][] komfort = {
				{1,1,7},
				{1,1,3},
				{1.0f/7, 1.0f/3,1}
		};
		
		float[][] osiagi = {
				{1,7,9},
				{1.0f/7,1,1},
				{1.0f/9, 1,1}
		};
		
		
		float[][][] otherMatrixes = {bezp, cena, komfort, osiagi};
		
		System.out.println("preference matrix:");
		ahpEngine.setPreferencesMatrix(prefMatrix);
		System.out.println("otherMatrixes:");
		ahpEngine.setMatrixes(otherMatrixes);
						
		System.out.println("calculateC(prefMatrix)");
		float[] c = ahpEngine.calculateC(prefMatrix);
		
		System.out.println("calculateC()");
		float[][] cMatrix = new float[otherMatrixes.length][];
		for (int i = 0; i < otherMatrixes.length; i++) {
			cMatrix[i] = ahpEngine.calculateC(otherMatrixes[i]);			
		}		
		System.out.println();
		
		System.out.println("normalizedPreferenceMatrix");
		prefMatrix = ahpEngine.normalizeMatrix(prefMatrix);
		printMatrix(prefMatrix);
		
//		System.out.println();
		System.out.println("normalizedOtherMatrixes");
		for (int i = 0; i < otherMatrixes.length; i++) {
			otherMatrixes[i] = ahpEngine.normalizeMatrix(otherMatrixes[i]);			
		}		
		printAllFeatureMatrixes(otherMatrixes);
		
		System.out.println("calculateVectorS(prefMatrix)");
		float[] vectorS;
		vectorS = ahpEngine.calculateVectorS(prefMatrix);
		printVector(vectorS);
				
		System.out.println("calculateVectorsS(otherMatrix)");
		float[][] vectorsS = new float[otherMatrixes.length][];
		for (int i = 0; i < otherMatrixes.length; i++) {
			vectorsS[i] = ahpEngine.calculateVectorS(otherMatrixes[i]);
			printVector(vectorsS[i]);
		}
		
		System.out.println("calculateLambdaMax");
		float lambda =  ahpEngine.calculateLambdaMax(c, vectorS);
		System.out.println(lambda);
		
		System.out.println("calculateLambdaMaxVector");
		float[] lambdaVector = new float[otherMatrixes.length]; 
		for (int i = 0; i < otherMatrixes.length; i++) {
			lambdaVector[i] = ahpEngine.calculateLambdaMax(cMatrix[i], vectorsS[i]);			
		}
		printVector(lambdaVector);
		
		System.out.println("checkConsistency(prefMatrix)");
		ahpEngine.checkConsistency(c, vectorS);
		
		System.out.println("checkConsistency(forOtherMatrixes)");
		for (int i = 0; i < otherMatrixes.length; i++) {
			ahpEngine.checkConsistency(cMatrix[i], vectorsS[i]);
		}
		
		System.out.println("ChooseBestVariant");
		float[] vectorR =  ahpEngine.calculateVectorR(vectorsS, vectorS);
		printVector(vectorR);
		
		
		
		int[] indexesInOrder;
		indexesInOrder = ahpEngine.indexesInOrderNewer(vectorR);
		System.out.println("Indexes in order:");
		for (int i : indexesInOrder) {
			System.out.print(i+" ");
		}
		
		indexesInOrder = ahpEngine.indexesInOrderNewer(new float[]{5,2,5,1,4,4,0,4});
		System.out.println("Indexes in order:");
		for (int i : indexesInOrder) {
			System.out.print(i+" ");
		}
		
	}
}