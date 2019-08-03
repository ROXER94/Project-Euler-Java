package projecteuler;

public class Problem072 {

	/**
	 * Calculates the number of elements in the set of reduced proper fractions for d ≤ 1,000,000
	 */
	static void solution() {
		long ans = 0;
		for (int i = 2; i <= 1000000; i++)
			ans += Functions.getPhi(i);
		System.out.println(ans);
	}
}