package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem089 {

	/**
	 * @param s
	 * @return the number of characters saved by writing s in its minimal Roman Numeral form
	 */
	static int getRomanreplacementCount(String s) {
		int charactersReplaced = 0;
		while (s.contains("IIII")) {
			s = s.replace("IIII", "IV");
			charactersReplaced += 2;
		}
		while (s.contains("VIV")) {
			s = s.replace("VIV", "IX");
			charactersReplaced++;
		}
		while (s.contains("XXXX")) {
			s = s.replace("XXXX", "XL");
			charactersReplaced += 2;
		}
		while (s.contains("LXL")) {
			s = s.replace("LXL", "XC");
			charactersReplaced++;
		}
		while (s.contains("CCCC")) {
			s = s.replace("CCCC", "CD");
			charactersReplaced += 2;
		}
		while (s.contains("DCD")) {
			s = s.replace("DCD", "CM");
			charactersReplaced++;
		}
		return charactersReplaced;
	}

	/**
	 * Calculates the number of characters saved by writing each line of the text file in its minimal Roman Numeral form
	 */
	static void solution() {
		int ans = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p089_roman.txt"))) {
			String line = br.readLine();
			while (line != null) {
				ans += getRomanreplacementCount(line);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}
}