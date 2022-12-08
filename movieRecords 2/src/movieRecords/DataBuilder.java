package movieRecords;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class DataBuilder {
	
	Scanner sc = new Scanner(System.in);

	private HashMap<Integer, FullMovieBase> MovieCollection = new HashMap<Integer, FullMovieBase>();
	

	void fileBuilder() {
		// fetch files
		try {
			File rep = new File("movie_data/");
			File[] list = rep.listFiles();
			ArrayList<String> filenames = new ArrayList<String>();
			for ( int i = 0; i < list.length; i++) {
				filenames.add(list[i].getName());
			}
			//System.out.println(filenames);
			for (int i = 0; i < filenames.size(); i++) {
				String sample = ("movie_data/"+ filenames.get(i));
				Scanner s = new Scanner(new File(sample));
				int counter = 0;
				while (s.hasNextLine()){
					FullMovieBase movie = new FullMovieBase();
					List<String> oneRecord = oneLineToList(s.nextLine());
					// if (cast file)
					// && 
					// if (box office file)
					if (sample.contentEquals("movie_data/imdb_movies_gross.txt") && !(oneRecord.get(oneRecord.size()-1).contentEquals("USA Box Office"))) {
						//System.out.println(oneRecord);
						// set movie values
						
						movie.setTitle(oneRecord.get(1));
						movie.setBoxOffice(Integer.parseInt(oneRecord.get(3)));
						MovieCollection.put(Integer.parseInt(oneRecord.get(2)), movie);
						
						//movie.set
						//MovieCollection.put(Integer.parseInt(oneRecord.get(2)), movie);
						//System.out.println(movie.getTitle());
						//System.out.println(movie.getBoxOffice());
					}
					if (sample.contentEquals("movie_data/imdb_movies_cast.txt") && !(oneRecord.get(oneRecord.size()-1).contentEquals("Cast 5"))) { //&& (oneRecord.get(oneRecord.size()-1)!=("USA Box Office"))) {
						//System.out.println(oneRecord);
						//loop through movie collection
						
						for (Entry<Integer, FullMovieBase> entry : MovieCollection.entrySet()) {
							//if (movie.get and title match, add unique variables
							if (Integer.parseInt(oneRecord.get(2)) == entry.getKey() && oneRecord.get(1).equalsIgnoreCase(entry.getValue().getTitle())) {
								entry.getValue().setCast1(oneRecord.get(4));
								entry.getValue().setCast2(oneRecord.get(5));
								entry.getValue().setCast3(oneRecord.get(6));
								entry.getValue().setCast4(oneRecord.get(7));
								entry.getValue().setCast5(oneRecord.get(8));
								entry.getValue().setDirector(oneRecord.get(3));
							}
						
						

					}
					// if (rating file)
					if (sample.contentEquals("movie_data/imdb_movies_toprated.txt") && !(oneRecord.get(oneRecord.size()-1).contentEquals("IMDb Rating"))) {
						//System.out.println(oneRecord);
						for (Entry<Integer, FullMovieBase> entry : MovieCollection.entrySet()) {
							//if (movie.get and title match, add unique variables
							if (Integer.parseInt(oneRecord.get(2)) == entry.getKey() && oneRecord.get(1).equalsIgnoreCase(entry.getValue().getTitle())) {
								entry.getValue().setImdbRating(Integer.parseInt(oneRecord.get(3)));
							}
						
						}
					}
					}
					}
					}
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
//		for (Entry<Integer, FullMovieBase> entry : MovieCollection.entrySet()) {
//			System.out.println(entry.getKey() + entry.getValue().getTitle());
//		}
		System.out.println("Choose an option (Enter Letter):");
		System.out.println("E  What is the total earnings listed for a specific year?");
		System.out.println("D  Give a list of all the directors in the database.");
		System.out.println("C  Who are the top 5 most common directors in the database?");
		System.out.println("S  Who starred/directed in a certain ranked/rated movie?");
		System.out.println("M  Which director earned the most money for a single movie?");
		System.out.println("Q  Quit");
		String str = sc.nextLine();
		Query query = new Query();
		query.main(MovieCollection, str);
	}

	public List<String> oneLineToList(String line) {
		List<String> movieInfo = Arrays.asList(line.split("\t"));
		return movieInfo;
	}
}
