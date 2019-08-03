package projecteuler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem091 {

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return True if the triangle formed from (0,0), (x1,y1), and (x2,y2) is a right triangle
	 */
	static boolean isRightTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		double s1 = Functions.getDistance(x1, y1, x2, y2);
		double s2 = Functions.getDistance(x2, y2, x3, y3);
		double s3 = Functions.getDistance(x1, y1, x3, y3);
		double[] sides = new double[] { s1, s2, s3 };
		Arrays.sort(sides);
		return Math.round(sides[0] * sides[0] + sides[1] * sides[1]) == Math.round(sides[2] * sides[2]);
	}

	/**
	 * Calculates the number of right triangles that can be formed with integer coordinates in a given range and joined at the origin
	 */
	static void solution() {
		int ans = 0;
		int limit = 50;
		Set<List<List<Integer>>> rightTriangles = new HashSet<List<List<Integer>>>();
		for (int x1 = 1; x1 <= limit; x1++)
			for (int y1 = 0; y1 <= limit; y1++)
				for (int x2 = 0; x2 <= limit; x2++)
					for (int y2 = 1; y2 <= limit; y2++)
						if (isRightTriangle(0, 0, x1, y1, x2, y2)
								&& !rightTriangles.contains(Functions.getTuple(Functions.getTuple(x1, y1), Functions.getTuple(x2, y2)))
								&& !rightTriangles.contains(Functions.getTuple(Functions.getTuple(x2, y2), Functions.getTuple(x1, y1)))) {
							rightTriangles.add(Functions.getTuple(Functions.getTuple(x1, y1), Functions.getTuple(x2, y2)));
							ans++;
						}
		ans -= limit * limit;
		System.out.println(ans);
	}
}