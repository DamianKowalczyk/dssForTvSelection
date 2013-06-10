package damiankowalczyk.studies.swd;

public enum TVGraphicalFeatures {

	FRAME_APPEARANCE, SHAPE_OF_FOOT, FLAT_MOUNTING_INTERFACE;

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
