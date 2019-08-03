package projecteuler;

public class Problem028 {

	/**
	 * Calculates the sum of the numbers on the diagonals in a 1001x1001 spiral
	 */
	static void solution() {
		int ans = 1;
		for (int i = 3; i <= 1001; i += 2)
			ans += 4 * i * i - 6 * i + 6;
		System.out.println(ans);
	}
}