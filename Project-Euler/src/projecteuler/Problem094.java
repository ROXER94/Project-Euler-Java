package projecteuler;

public class Problem094 {

	/**
	 * Calculates the sum of the perimeters of all almost equilateral triangles with integral side lengths and area and whose perimeters do not exceed
	 * 1,000,000,000
	 */
	static void solution() {
		int ans = 0;
		int s = 5;
		int t = -1;
		int previous = 1;
		while (s < 333333334) {
			ans += 3 * s - t;
			int p = s;
			s = 4 * s - previous + 2 * t;
			t *= -1;
			previous = p;
		}
		System.out.println(ans);
	}
}