package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem022 {

	/**
	 * Calculates the sum of the score of each name in the text file
	 */
	static void solution() {
		int ans = 0;
		List<String> names = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p022_names.txt"))) {
			String[] name = br.readLine().replaceAll("\"", "").split(",");
			Arrays.stream(name).map(String::toString).forEach(names::add);
			Collections.sort(names);
			for (String s : names) {
				int currentScore = 0;
				for (char c : s.toCharArray())
					currentScore += c - 'A' + 1;
				ans += currentScore * (names.indexOf(s) + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}
}