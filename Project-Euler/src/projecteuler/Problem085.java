package projecteuler;

public class Problem085 {

	/**
	 * @param l
	 * @param w
	 * @return the number of rectangles contained in a l x w grid
	 */
	static int getRectangleCount(int l, int w) {
		return l * w * (l + 1) * (w + 1) / 4;
	}

	/**
	 * Calculates the area of the grid that contains nearly 2,000,000 rectangles
	 */
	static void solution() {
		int ans = 0;
		int currentDifference = 100;
		for (int l = 1; l < 1000; l++)
			for (int w = 1; w < 1000; w++) {
				int rectangleCount = getRectangleCount(l, w);
				if (Math.abs(2000000 - rectangleCount) < currentDifference) {
					currentDifference = Math.abs(2000000 - rectangleCount);
					ans = l * w;
				}
			}
		System.out.println(ans);
	}
}