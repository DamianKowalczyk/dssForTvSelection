package damiankowalczyk.studies.swd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;


public class TVsetsForCompare {
	
	ArrayList<TVset> loadedTvs = new ArrayList<>(0);
	ArrayList<TVset> TvsToCompare = new ArrayList<TVset>(0);	
	
	private String pathToFile;
	
	public TVsetsForCompare() {		
		checkFileLocation();
		loadTVsets();
	}
	
	private void checkFileLocation(){
		CodeSource codeSource = DssForTvSelection.class.getProtectionDomain().getCodeSource();
		File jarFile;
		try {
			jarFile = new File(codeSource.getLocation().toURI().getPath());
			pathToFile = jarFile.getParentFile().getPath();			
			System.out.println(pathToFile);			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadTVsets(){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(pathToFile+"\\TVSets\\descriptions\\TVsets.txt"));			
			//br = new BufferedReader(new FileReader("TVSets/descriptions/TVsets.txt"));
			String line;
			while ((line = br.readLine()) != null) {
			   loadedTvs.add(createNewTVset(line));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
		
	private TVset createNewTVset(String TVdescriptionFromFile){
		String[] tvFeatures;
		tvFeatures = TVdescriptionFromFile.split(";");
		TVset result = new TVset(tvFeatures, pathToFile+"\\TVSets\\images\\");		
		
		/*if (tvFeatures[3]!="")
			result.internetFunction = tvFeatures[3];*/		
		return result;
	}
	
	private ArrayList<TVset> chooseOnlyTVWithChoosenParameters(List<String> choosenOption){
		// modify this code in further time
		//should make some filtration
		//TvsToCompare=loadedTvs;
		
		String matrixKind = "";
		String displaySize = "";
		
		TvsToCompare = new ArrayList<TVset>(0);		
		for (TVset currentTV : loadedTvs) {
			//ArrayList<String> feauturesOfTV= currentTV.feautures;
			matrixKind = currentTV.feautures.get(1).toString(); // matrix kind is on the second position in txt file
			displaySize = currentTV.feautures.get(2).toString(); // display size is on the second position in txt file
			
//			matrixKind = feauturesOfTV.get(1); // matrix kind is on the second position in txt file
//			displaySize = feauturesOfTV.get(2); // display size is on the second position in txt file
			
			int displaySizeIntValue = Integer.parseInt(displaySize);
			
			if(displaySizeIntValue>=19 && displaySizeIntValue<=28)
				displaySize = "19-28";
			else if(displaySizeIntValue>=32 && displaySizeIntValue<=39)
				displaySize = "32-39";
			else if(displaySizeIntValue>=40 && displaySizeIntValue<=42)
				displaySize = "40-42";
			else if(displaySizeIntValue>=43)
				displaySize = "43+";
			else 
				displaySize = "stringWithForShureWontBeInChoosenOptions";
			
			//if (choosenOption.contains(matrixKind)&&choosenOption.contains(displaySize))
			if (areBothInChoosenOptions(matrixKind, displaySize, choosenOption))
				TvsToCompare.add(currentTV);
		}
		
		return TvsToCompare;
	}
	
	private boolean areBothInChoosenOptions(String matrixKind, String displaySize , List<String> choosenOptions){
		boolean isMatrixInChoosenOptions = false;
		boolean isDisplaySizeInChoosenOptions = false;
		
		for (String currentOptionValue : choosenOptions) {
			if (currentOptionValue.equals(matrixKind))
				isMatrixInChoosenOptions = true;
			else if (currentOptionValue.equals(displaySize)) {
				isDisplaySizeInChoosenOptions = true;
			}
		}
		return isMatrixInChoosenOptions && isDisplaySizeInChoosenOptions;
	}
	
	public ArrayList<TVset> getFilteredTVs(List<String> choosenOption) {
		return chooseOnlyTVWithChoosenParameters(choosenOption);
	}
	
}
