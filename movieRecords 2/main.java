package movieRecords;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class main {

	 public static void main(String[] args) {
		DataBuilder test = new DataBuilder();
		test.fileBuilder();
	}

		@Test
		public void Test() {
			Scanner in = new Scanner(System.in);
			int[] input = {1,2,3,4,5};
			int[] test_answer = shiftList(input, in, 3);
			int[] answer = {3,4,5,1,2};
			assertTrue(Arrays.equals(answer, test_answer));
		}
		 
}
