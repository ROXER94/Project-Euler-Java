package projecteuler;

public class Problem577 {

	/**
	 * Calculates the number of regular hexagons that can be found by connecting six triangular lattice points in an equilateral triangle with side lengths of 3
	 * to 12345
	 */
	static void solution() {
		long ans = 0;
		for (int n = 3; n <= 12345; n++)
			for (int i = 3; i <= n; i += 3)
				ans += (long) i * (n - i + 1) * (n - i + 2) / 6;
		System.out.println(ans);
	}
}