package projecteuler;

public class Problem108 {

	/**
	 * Calculates the least value of n for which the number of distinct solutions of the equation x^-1 + y^-1 = n^-1 exceeds 1000
	 */
	static void solution() {
		int ans = 0;
		while (Functions.getFactors((long) Math.pow(ans, 2)).size() < 2000)
			ans += (2 * 3 * 5 * 7);
		System.out.println(ans);
	}
}