package movieRecords;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class QueryE extends Query {
	private int totalEarned;
	
	public void main(HashMap<Integer, FullMovieBase> movieCollection) {
		System.out.println("What year would you like to see?");
		int year = Integer.parseInt(sc.nextLine());
		totalEarned = 0;
		 for (Entry<Integer, FullMovieBase> set : movieCollection.entrySet()) {
			if (set.getKey()==year) {
				totalEarned = totalEarned + (set.getValue().getBoxOffice());
			}
		}
		System.out.println("Total earned for " + year + " is $" + totalEarned);
	}
}
