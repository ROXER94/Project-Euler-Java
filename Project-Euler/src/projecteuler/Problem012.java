package projecteuler;

public class Problem012 {

	/**
	 * Calculates the first triangle number to have over five hundred divisors
	 */
	static void solution() {
		int ans = 1;
		while (true) {
			if (Functions.getFactors(Functions.getTriangle(ans)).size() > 500)
				break;
			ans++;
		}
		System.out.println(Functions.getTriangle(ans));
	}
}