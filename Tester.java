package sortcomparison;

import java.util.*;

public class Tester {

	public static void main(String[] args) {

		// String[] words = { "Ken", "Bob", "Alex", "Al", "Ann", "Gail", "Don", "Roya", "Rex", "Norm", "Rich", "Tal",
		// "Sue", "Ted" };
		//
		// ArrayList<String> listwords = new ArrayList<>();
		//
		// for (String word : words) {
		// listwords.add(word);
		// }
		// BasicSorter bSorter = new BasicSorter();
		// bSorter.mergeSort(listwords, 0, 14);
		// for (String word : listwordswords) {
		// System.out.println(word);
		// }

		ArrayList<String> words = new ArrayList<String>();
		for (String s : new String[] { "M", "B", "Z", "A", "F", "D", "C", "P", "Q", "E", "V", "X" })
			words.add(s);

		ArrayList<String> expectedWords = new ArrayList<String>(words.subList(6, 12));
		Collections.sort(expectedWords);

		BasicSorter bSorter = new BasicSorter();
		bSorter.merge(words, 6, 3, 3);

		for (int i = 0; i < expectedWords.size(); i++) {
			System.out.println(words.get(i + 6) + "  " + expectedWords.get(i));
		}

	}

}
