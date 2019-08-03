package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem067 {

	/**
	 * Calculates the maximum total from top to bottom of the triangle
	 */
	static void solution() {
		List<Integer[]> matrix = new ArrayList<Integer[]>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p067_triangle.txt"))) {
			String line = br.readLine();
			while (line != null) {
				matrix.add(Arrays.stream(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new));
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer[][] m = matrix.toArray(new Integer[matrix.size()][]);
		Integer[] t = m[m.length - 1];
		for (int i = m.length - 2; i >= 0; i--) {
			Integer[] current = new Integer[m[i].length];
			for (int j = 0; j < m[i].length; j++)
				current[j] = Math.max(m[i][j] + t[j], m[i][j] + t[j + 1]);
			t = current;
		}
		System.out.println(t[0]);
	}
}