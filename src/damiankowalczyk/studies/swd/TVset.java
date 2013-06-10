package damiankowalczyk.studies.swd;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TVset {		
		
	ArrayList<String> feautures; 		
	Image image;
		
	public TVset() {
		int featuresNumber = TVBasicFeatures.values().length;
		feautures = new ArrayList<String>(featuresNumber);
	}
	
	public TVset(String[] tvFeatures) {
		this();
		setFeautures(tvFeatures);
		loadImage();
	}

	private void setFeautures(String[] feaut){
		for (int i = 0; i < feaut.length; i++) {
			feautures.add(feaut[i]);
		}
	}
	
	private void loadImage() {
		try {
			image = ImageIO.read(new File("/images/TVsets/"+feautures.get(0)+"jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TVset tVset = new TVset();
		/*tVset.name = "samsung";
		tVset.size = 50.0f;*/
		tVset.loadImage();	
	}
}
