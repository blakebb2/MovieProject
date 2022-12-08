package movieRecords;

import java.util.HashMap;
import java.util.Scanner;

public class Query extends DataBuilder{
	String name;
	String year;
	String gender;
	Scanner sc = new Scanner(System.in);

	void main(HashMap<Integer, FullMovieBase> movieCollection, String str) {
	// Create User Input Variable

			  
			//String str = sc.nextLine();
			decider(str, movieCollection);
	}
	private void decider(String choice, HashMap<Integer, FullMovieBase> movieCollection) {
		if (choice.contentEquals("E")) {
			QueryE queryE = new QueryE();
			queryE.main(movieCollection);
		}
		if (choice.contentEquals("D")) {
			QueryD queryD = new QueryD();
			queryD.main(movieCollection);
		}
		if (choice.contentEquals("C")) {
			QueryC queryC = new QueryC();
			queryC.main(movieCollection);
		}
		if (choice.contentEquals("S")) {
			QueryS queryS = new QueryS();
			queryS.main(movieCollection);
		}
		if (choice.contentEquals("M")) {
			QueryM queryM = new QueryM();
			queryM.main(movieCollection);
		}
		else {
			System.out.println("Enter a valid letter:");
			decider(sc.nextLine(), movieCollection);
		}
	}
}

/*
Give the total US box office earnings in the database in a single year.
Example:  “What is the total earnings listed in 2007?


Give a list of all the directors of movies in the database.  The list should be in alphabetical order and not list any director twice.


Give a list of some number of directors who appear most in the database.  The list should be given in order of the number of appearances.
Example: “Give a list of the top 5 directors who appear most.”


Tell the director or cast members who starred in a movie, given the movie’s rating rank or money rank. 
Examples: 
“Who starred in the third highest-grossing movie?”
“Who directed the 100th highest-ranked movie?”

Implement at least one other query, of your own choosing.
*/