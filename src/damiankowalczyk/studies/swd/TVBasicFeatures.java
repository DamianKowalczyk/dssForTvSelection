package damiankowalczyk.studies.swd;

public enum TVBasicFeatures {
	BRAND, DISPLAY_TECHNOLOGY, SCREEN_SIZE, INTERNET_FUNCTIONS, FLAT_MOUNTING_INTERFACE;
	
	public String toString() {
		String s = super.toString();
		String[] words = s.split("_");
		String result;
		result = words[0].substring(0, 1) + words[0].substring(1).toLowerCase();

		for (int i = 1; i < words.length; i++) {
			result += " " + words[i].toLowerCase();
		}

		return result;
	}
}
