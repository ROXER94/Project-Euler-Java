package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem099 {

	/**
	 * Calculates the line number of the text file that has the greatest numerical value
	 */
	static void solution() {
		int ans = 0;
		int lineCount = 1;
		double maximumValue = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p099_base_exp.txt"))) {
			String line = br.readLine();
			while (line != null) {
				double currentValue = Integer.parseInt(line.split(",")[1]) * Math.log(Integer.parseInt(line.split(",")[0]));
				if (currentValue > maximumValue) {
					maximumValue = currentValue;
					ans = lineCount;
				}
				lineCount++;
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}
}