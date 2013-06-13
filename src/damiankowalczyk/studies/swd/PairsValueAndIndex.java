package damiankowalczyk.studies.swd;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.experimental.categories.Categories.ExcludeCategory;

public class PairsValueAndIndex implements Comparable<PairsValueAndIndex>{
	float value;
	int index;
	
	public PairsValueAndIndex(float value, int index) {
		this.value = value;
		this.index = index;
	}
	
	@Override
	public boolean equals(Object obj) {		
		return (obj instanceof PairsValueAndIndex)? this.value == ((PairsValueAndIndex) obj).value : false;
	}

	@Override
	public int compareTo(PairsValueAndIndex o) {
		return (this.value>o.value)? 1 : (this.value < o.value)? -1 : 0;		
	}
	
	
	/*private LinkedList<Dictionary> listOfPairs;
	
	public Dictionary(float value, int index) {
		this.value = value;
		this.index = index;
	}
	
	int[] getIndexesOrderAfterSortByValue(float[] vectorR){
		float[] copyOfVector = new float[vectorR.length];
		for (int i = 0; i < vectorR.length; i++)
			copyOfVector[i] = vectorR[i];
		
		listOfPairs = new LinkedList<Dictionary>();
		
		for (int i = 0; i < vectorR.length; i++)
			listOfPairs.add(new Dictionary(vectorR[i], i));

		Arrays.sort(copyOfVector);

		int[] result = new int[vectorR.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = findIndexForValue(copyOfVector[i], vectorR);
		}
		return result;
		
	}
	
	private int findIndexForValue(float value, float[] vectorR) {
		int index = 0;
		for (Dictionary d : listOfPairs) {
			if(d.value==value)
				return listOfPairs.remove(index)
		}
		return index;
	}*/
}
