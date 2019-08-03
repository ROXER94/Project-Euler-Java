package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem042 {

	/**
	 * Calculates the number of triangle words in the text file
	 */
	static void solution() {
		int ans = 0;
		List<String> words = new ArrayList<>();
		HashSet<Long> triangle = new HashSet<Long>();
		for (int i = 1; i <= 30; i++)
			triangle.add(Functions.getTriangle(i));
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p042_words.txt"))) {
			String[] word = br.readLine().replaceAll("\"", "").split(",");
			Arrays.stream(word).map(String::toString).forEach(words::add);
			for (String s : words) {
				int currentScore = 0;
				for (char c : s.toCharArray())
					currentScore += c - 'A' + 1;
				if (triangle.contains((long) currentScore))
					ans++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}
}