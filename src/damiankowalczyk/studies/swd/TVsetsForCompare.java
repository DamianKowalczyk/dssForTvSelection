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
			   // process the line.
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
	
	public TVset createNewTVset(String TVdescription){
		String[] tvFeatures;
		tvFeatures = TVdescription.split(";");
		TVset result = new TVset();
		result.name = tvFeatures[0];
		result.panel = tvFeatures[1];
		result.size = Float.parseFloat(tvFeatures[2]);
		result.price = Float.parseFloat(tvFeatures[3]);
		result. 
		
		/*if (tvFeatures[3]!="")
			result.internetFunction = tvFeatures[3];*/
		
		
		return result;
	}
	
}
