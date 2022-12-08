package movieRecords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class QueryD {
	
	private ArrayList<String> directorList = new ArrayList<String>();

	public void main(HashMap<Integer, FullMovieBase> movieCollection) {
		System.out.println(directorList);
		for (Entry<Integer, FullMovieBase> entry : movieCollection.entrySet()) {
			if (directorList.contains(entry.getValue().getDirector())) {
				
			}
			else {
				directorList.add(entry.getValue().getDirector());
			}
		}
		System.out.println(directorList);
	}

}
