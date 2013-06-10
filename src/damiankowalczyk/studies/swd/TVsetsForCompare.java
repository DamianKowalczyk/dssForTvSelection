package damiankowalczyk.studies.swd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TVsetsForCompare {
	
	ArrayList<TVset> loadedTvs = new ArrayList<TVset>();
	ArrayList<TVset> TvsToCompare = new ArrayList<TVset>();	
	
	public void loadTVsets(){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("/TVSets/descriptions/TVsets.txt"));
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
		TVset result = new TVset(tvFeatures);		
		
		/*if (tvFeatures[3]!="")
			result.internetFunction = tvFeatures[3];*/		
		return result;
	}
	
	private ArrayList<TVset> chooseOnlyTVWithChoosenParameters(){
		// modify this code in further time
		//should make some filtration
		TvsToCompare = loadedTvs;
		
		return TvsToCompare;
	}
	
	public ArrayList<TVset> getFilteredTVs() {
		return chooseOnlyTVWithChoosenParameters();
	}
	
}
