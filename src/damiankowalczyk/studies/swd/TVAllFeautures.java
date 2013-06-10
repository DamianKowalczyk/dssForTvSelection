package damiankowalczyk.studies.swd;

public class TVAllFeautures {

	String[] listOfAllFeatures;

	String[][] allPossiblePairs;

	public TVAllFeautures() {
		createListOfAvailableFeatures();
		generateAllPossiblePairs();
	}

	public String[] getListOfAllFeatures() {
		return listOfAllFeatures;
	}

	public String[][] getAllPossiblePairs() {
		return allPossiblePairs;
	}

	private void createListOfAvailableFeatures() {
		int allFeaturesNumber = TVBasicFeatures.values().length
				+ TVGraphicalFeatures.values().length;
		listOfAllFeatures = new String[allFeaturesNumber];

		int i = 0;
		for (TVBasicFeatures basFeat : TVBasicFeatures.values()) {
			listOfAllFeatures[i] = basFeat.toString();
			i++;
		}

		for (TVGraphicalFeatures grafFeat : TVGraphicalFeatures.values()) {
			listOfAllFeatures[i] = grafFeat.toString();
			i++;
		}
	}

	private void generateAllPossiblePairs() {
		int numberOfPairs = (listOfAllFeatures.length * (listOfAllFeatures.length - 1)) / 2;
		allPossiblePairs = new String[numberOfPairs][2];
		
		int index = 0;
		for (int i = 0; i < listOfAllFeatures.length - 1; i++) {
			for (int j = i + 1; j < listOfAllFeatures.length; j++) {
				allPossiblePairs[index][0] = listOfAllFeatures[i];
				allPossiblePairs[index][1] = listOfAllFeatures[j];
				index++;
			}
		}
	}

	public void printAllPairs() {
		for (int i = 0; i < allPossiblePairs.length; i++) {
			System.out.println(i + ". " + allPossiblePairs[i][0] + " - "
					+ allPossiblePairs[i][1]);
		}
	}

	public static void main(String[] args) {
		new TVAllFeautures().printAllPairs();
	}

}
