package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem039 {

	/**
	 * Calculates the perimeter length that produces the maximum number of integer right triangles
	 */
	static void solution() {
		List<List<Integer>> pythagoreanTriplesList = new ArrayList<List<Integer>>();
		for (int a = 1; a < 481; a++)
			for (int b = a + 1; b < 481; b++) {
				double c = Math.sqrt(a * a + b * b);
				if (Functions.isSquare((int) (c * c)) && a + b + c <= 1000)
					pythagoreanTriplesList.add(Arrays.asList(a, b, (int) c));
			}
		int maximumCount = 0;
		int perimeter = 12;
		List<List<Integer>> countList = new ArrayList<List<Integer>>();
		while (perimeter <= 1000) {
			int currentCount = 0;
			for (List<Integer> i : pythagoreanTriplesList) {
				if (Functions.getIntListSum(i) == perimeter)
					currentCount++;
				if (currentCount > maximumCount) {
					maximumCount = currentCount;
					countList.add(i);
				}
			}
			perimeter++;
		}
		System.out.println(Functions.getIntListSum(countList.get(countList.size() - 1)));
	}
}