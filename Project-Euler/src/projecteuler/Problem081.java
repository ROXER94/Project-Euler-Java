package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem081 {

	/**
	 * Calculates the number of distinct arrangements of the two cubes that allow for all of the square numbers to be displayed
	 */
	static void solution() {
		List<Integer[]> matrix = new ArrayList<Integer[]>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p081_matrix.txt"))) {
			String line = br.readLine();
			while (line != null) {
				matrix.add(Arrays.stream(Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new));
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer[][] m = matrix.toArray(new Integer[matrix.size()][]);
		int n = 80;
		for (int i = 1; i < n; i++)
			m[0][i] += m[0][i - 1];
		for (int j = 1; j < n; j++)
			m[j][0] += m[j - 1][0];
		for (int i = 1; i < n; i++)
			for (int j = 1; j < n; j++)
				m[i][j] += Math.min(m[i][j - 1], m[i - 1][j]);
		System.out.println(m[n - 1][n - 1]);
	}
}