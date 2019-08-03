package projecteuler;

public class Problem120 {

	/**
	 * Calculates the sum of the maximum remainders of ((a−1)^n + (a+1)^n) / a^2 for 3 ≤ a ≤ 1000
	 */
	static void solution() {
		int ans = 0;
		for (int a = 3; a <= 1000; a++)
			ans += (a + a % 2 - 2) * a;
		System.out.println(ans);
	}
}